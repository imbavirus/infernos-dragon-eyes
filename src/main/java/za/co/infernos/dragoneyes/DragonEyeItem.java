package za.co.infernos.dragoneyes;

import com.iafenvoy.iceandfire.data.DragonType;
import com.iafenvoy.iceandfire.entity.DragonBaseEntity;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.EyeOfEnder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

/**
 * Eye-of-ender style item that homes toward the nearest wild live dragon of a given type.
 * Behaviour ported from Eyes of Ice and Fire CE; rebranded as Infernos Dragon Eyes for 1.21.1.
 */
public class DragonEyeItem extends Item {
    private final DragonType type;

    public DragonEyeItem(Properties properties, DragonType type) {
        super(properties);
        this.type = type;
    }

    @Override
    @ParametersAreNonnullByDefault
    public @NotNull InteractionResultHolder<ItemStack> use(Level levelIn, Player playerIn, InteractionHand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);

        DragonBaseEntity dragonFound = getClosestDragon(levelIn, playerIn, type);
        if (dragonFound == null) {
            playerIn.displayClientMessage(Component.translatable("chat.infernos_dragon_eyes.no_dragons_found"), true);
            return InteractionResultHolder.pass(itemstack);
        }

        playerIn.startUsingItem(handIn);
        if (levelIn instanceof ServerLevel) {
            Vec3 head = dragonFound.getHeadPosition();
            BlockPos blockpos = BlockPos.containing(head);
            EyeOfEnder eyeOfEnder = new EyeOfEnder(levelIn, playerIn.getX(), playerIn.getY(0.5D), playerIn.getZ());
            eyeOfEnder.setItem(itemstack);
            eyeOfEnder.signalTo(blockpos);

            levelIn.addFreshEntity(eyeOfEnder);
            if (playerIn instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.USED_ENDER_EYE.trigger(serverPlayer, blockpos);
            }

            levelIn.playSound(
                    null,
                    playerIn.blockPosition(),
                    SoundEvents.ENDER_EYE_LAUNCH,
                    SoundSource.NEUTRAL,
                    0.5F,
                    0.4F / (levelIn.getRandom().nextFloat() * 0.4F + 0.8F)
            );
            levelIn.levelEvent(null, 1003, playerIn.blockPosition(), 0);

            if (!playerIn.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            playerIn.awardStat(Stats.ITEM_USED.get(this));
            playerIn.swing(handIn, true);
            return InteractionResultHolder.success(itemstack);
        }
        return InteractionResultHolder.consume(itemstack);
    }

    private static DragonBaseEntity getClosestDragon(Level world, Player player, DragonType type) {
        double x = player.getX();
        double y = player.getY();
        double z = player.getZ();

        // ~36 chunks horizontally — matches original CE search box
        AABB box = new AABB(x - 576, -64, z - 576, x + 576, y + 320, z + 576);
        List<DragonBaseEntity> listOfTargets = world.getEntitiesOfClass(DragonBaseEntity.class, box);

        float min = 0;
        DragonBaseEntity closest = null;
        for (DragonBaseEntity target : listOfTargets) {
            if (!target.isModelDead() && !target.isTame() && target.dragonType == type) {
                float distance = target.distanceTo(player);
                if (min == 0 || distance < min) {
                    min = distance;
                    closest = target;
                }
            }
        }
        return closest;
    }
}
