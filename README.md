# Eyes of Ice and Fire — Community Edition (1.21.1 NeoForge)

Unofficial **NeoForge 1.21.1** port of [Eyes of Ice and Fire Community Edition](https://www.curseforge.com/minecraft/mc-mods/eyes-of-ice-and-fire-community-edition)
(Groupix05 fork of LucianoWayand's Eyes of Ice and Fire / Eye of Dragons lineage).

License: **LGPL-3.0** (upstream).

## What it does

Craft eyes of ender from Ice and Fire CE dragon blood. Right-click to send an eye toward the nearest
**wild, living** dragon of that type within ~36 chunks.

| Eye | Blood |
|-----|-------|
| Eye of Fire Dragon | `iceandfire:fire_dragon_blood` + ender pearl |
| Eye of Ice Dragon | `iceandfire:ice_dragon_blood` + ender pearl |
| Eye of Lightning Dragon | `iceandfire:lightning_dragon_blood` + ender pearl |

## Requirements

- Minecraft **1.21.1**
- NeoForge **21.1.x**
- [Ice and Fire Community Edition](https://modrinth.com/mod/iceandfire-ce) **2.0+** (tested on **2.1-beta.1**)
  - pulls **uranus**, **jupiter**, **geckolib**

## Build

```bash
# Place compile jars in libs/ (see libs/README) or use an existing Infernos launcher pack copy
export JAVA_HOME="/c/Program Files/Eclipse Adoptium/jdk-21.0.9.10-hotspot"
./gradlew.bat build
```

Output: `build/libs/eyesoficeandfire-1.21.1-neoforge-1.3.0-1.21.1.jar`

## Port notes (1.20.1 Forge → 1.21.1 NeoForge)

- Forge → NeoForge moddev plugin / `neoforge.mods.toml`
- `EntityDragonBase` → `DragonBaseEntity`
- `DragonType.FIRE|ICE|LIGHTNING` → `IafDragonTypes.FIRE|ICE|LIGHTNING`
- Deferred registers use NeoForge `DeferredRegister.Items` / `DeferredItem`
- Recipes under `data/.../recipe/` with 1.21 `result.id`
- `Player.isCreative()` → `getAbilities().instabuild`

## Credits

- MKuckert — Eye of Dragons
- LucianoWayand — Eyes of Ice and Fire
- Groupix05 — Community Edition (IceAndFire CE) fork
- Infernos / Imbavirus — 1.21.1 NeoForge port
