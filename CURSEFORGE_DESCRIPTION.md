# Infernos Dragon Eyes

Lore-friendly **eyes of ender** that help you find nearby dragons from **Ice and Fire: Community Edition**.

Craft a typed eye from an **ender pearl** and a bottle of **dragon blood**, then right-click. The eye flies toward the nearest **wild, living** dragon of that type (within roughly 36 chunks). Like vanilla eyes of ender, it may break — bring extras.

| Eye | Crafted with |
|-----|----------------|
| Eye of Fire Dragon | Ender Pearl + Fire Dragon Blood |
| Eye of Ice Dragon | Ender Pearl + Ice Dragon Blood |
| Eye of Lightning Dragon | Ender Pearl + Lightning Dragon Blood |

## Requirements

- Minecraft **1.21.1**
- **NeoForge** 21.1.x
- [Ice and Fire Community Edition](https://www.curseforge.com/minecraft/mc-mods/ice-and-fire-community-edition) **2.0+** (or [Modrinth](https://modrinth.com/mod/iceandfire-ce))

## Credits / original projects (required attribution)

This project is a **derivative / unofficial port**, not the original authors' release.

**Lineage (please support the originals):**

1. **Eye of Dragons** (original concept) — [CurseForge](https://www.curseforge.com/minecraft/mc-mods/eye-of-dragons) — MKuckert  
2. **Eyes of Ice and Fire** — [CurseForge](https://www.curseforge.com/minecraft/mc-mods/eyes-of-ice-and-fire) · [GitHub](https://github.com/lucianowayand/eyes-of-ice-and-fire) — LucianoWayand  
3. **Eyes of Ice and Fire Community Edition** (IceAndFire CE fork) — [CurseForge](https://www.curseforge.com/minecraft/mc-mods/eyes-of-ice-and-fire-community-edition) · [GitHub](https://github.com/Groupix05/eyes-of-ice-and-fire) — Groupix05  

**This project (Infernos Dragon Eyes):** 1.21.1 NeoForge port + rebrand by **Infernos / Imbavirus**  
- Source: https://github.com/imbavirus/infernos-dragon-eyes  
- Issues: https://github.com/imbavirus/infernos-dragon-eyes/issues  

## How this differs from the original

| | Upstream Eyes of Ice and Fire / CE | **Infernos Dragon Eyes** |
|--|-------------------------------------|---------------------------|
| **Mod id** | `eyesoficeandfire` | **`infernos_dragon_eyes`** (not a drop-in replacement) |
| **Minecraft** | Primarily **1.20.1 Forge** (CE) | **1.21.1 NeoForge only** |
| **Loader** | Forge | NeoForge |
| **Ice and Fire target** | IceAndFire CE 1.20.x APIs | IceAndFire CE **2.x** (`DragonBaseEntity`, `IafDragonTypes`, etc.) |
| **Branding / ownership** | LucianoWayand / Groupix05 | Infernos port — **not affiliated** with upstream authors |
| **Save / pack compatibility** | Own namespace | **Different items/recipes namespace** — does not replace upstream jars |

Gameplay idea is the same (blood-typed eyes → find wild dragons). Implementation is a fresh NeoForge 1.21.1 port under a new mod id so it cannot be confused with, or silently swap for, the original CF projects.

This is also **separate** from Ice and Fire CE’s built-in **Dragon Seeker** items (chat/coords style tools).

## License

**LGPL-3.0** — same family as the Eyes of Ice and Fire / CE lineage.

- SPDX: `LGPL-3.0-only`  
- Full text: https://www.gnu.org/licenses/lgpl-3.0.html  
- This distribution includes copyright notices for upstream contributors and Infernos modifications.  
- You may use, modify, and redistribute under LGPL-3.0 terms; modified versions must remain under LGPL-3.0 when required by the license.

If you are the upstream author and want changes to credits or distribution, open an issue on the GitHub repo above.

## The Infernos Dragon Eyes Team

Infernos / Imbavirus (port & maintenance)
