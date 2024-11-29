package org.siynes.sexpitems;

import org.siynes.sexpitems.utils.HexUtil;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class SExpItems extends JavaPlugin implements Listener {
    public static Plugin instance;

    public static Plugin getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        this.getServer().getPluginManager().registerEvents(new BukkitListener(), this);
        this.getServer().getPluginManager().registerEvents(this, this);
        this.saveDefaultConfig();
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("sexpitems") && args.length >= 1 && sender.hasPermission("sexpitems.admin")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                this.reloadConfig();
                sender.sendMessage(HexUtil.translate(this.getConfig().getString("messages.reload-config")));
                return true;
            }

            String materialName;
            String playerName = null;

            if (args.length >= 3 && args[0].equalsIgnoreCase("give")) {
                playerName = args[1];
                String itemType = args[2];
                Player player = this.getServer().getPlayer(playerName);
                ItemStack itemStack = null;

                if (player != null) {
                    itemStack = null;
                    boolean glow;
                    ItemMeta itemMeta = null;

                    if (itemType.equalsIgnoreCase("ender")) {
                        itemStack = new ItemStack(Material.ENDER_PEARL);
                        itemMeta = itemStack.getItemMeta();
                        itemMeta.setDisplayName(HexUtil.translate(this.getConfig().getString("items.ender.name")));

                        glow = this.getConfig().getBoolean("items.ender.glow");
                        if (glow) {
                            itemMeta.addEnchant(Enchantment.OXYGEN, 1, true);
                            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        }
                        List<String> lore = this.getConfig().getStringList("items.ender.lore");
                        List<String> translatedLore = new ArrayList<>();
                        for (String line : lore) {
                            translatedLore.add(HexUtil.translate(line));
                        }

                        itemMeta.setLore(translatedLore);

                        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                        itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("ender"), PersistentDataType.STRING, "ender");
                        itemStack.setItemMeta(itemMeta);
                    } else {
                        if (itemType.equalsIgnoreCase("illum")) {
                            itemStack = new ItemStack(Material.SEA_LANTERN);
                            itemMeta = itemStack.getItemMeta();
                            itemMeta.setDisplayName(HexUtil.translate(this.getConfig().getString("items.illum.name")));

                            glow = this.getConfig().getBoolean("items.illum.glow");
                            if (glow) {
                                itemMeta.addEnchant(Enchantment.OXYGEN, 1, true);
                                itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                            }
                            List<String> lore = this.getConfig().getStringList("items.illum.lore");
                            List<String> translatedLore = new ArrayList<>();
                            for (String line : lore) {
                                translatedLore.add(HexUtil.translate(line));
                            }

                            itemMeta.setLore(translatedLore);

                            itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                            itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("illum"), PersistentDataType.STRING, "illum");
                            itemStack.setItemMeta(itemMeta);
                        } else {
                            if (itemType.equalsIgnoreCase("grav")) {
                                itemStack = new ItemStack(Material.FEATHER);
                                itemMeta = itemStack.getItemMeta();
                                itemMeta.setDisplayName(HexUtil.translate(this.getConfig().getString("items.grav.name")));

                                glow = this.getConfig().getBoolean("items.grav.glow");
                                if (glow) {
                                    itemMeta.addEnchant(Enchantment.OXYGEN, 1, true);
                                    itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                                }
                                List<String> lore = this.getConfig().getStringList("items.grav.lore");
                                List<String> translatedLore = new ArrayList<>();
                                for (String line : lore) {
                                    translatedLore.add(HexUtil.translate(line));
                                }

                                itemMeta.setLore(translatedLore);

                                itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                                itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("grav"), PersistentDataType.STRING, "grav");
                                itemStack.setItemMeta(itemMeta);
                            } else {
                                if (itemType.equalsIgnoreCase("artefender")) {
                                    itemStack = new ItemStack(Material.CONDUIT);
                                    itemMeta = itemStack.getItemMeta();
                                    itemMeta.setDisplayName(HexUtil.translate(this.getConfig().getString("items.artefender.name")));

                                    List<String> lore = this.getConfig().getStringList("items.artefender.lore");
                                    List<String> translatedLore = new ArrayList<>();
                                    for (String line : lore) {
                                        translatedLore.add(HexUtil.translate(line));
                                    }

                                    itemMeta.setLore(translatedLore);

                                    itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                                    itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("artefender"), PersistentDataType.STRING, "artefender");
                                    itemStack.setItemMeta(itemMeta);
                                } else {
                                    if (itemType.equalsIgnoreCase("artef")) {
                                        itemStack = new ItemStack(Material.CONDUIT);
                                        itemMeta = itemStack.getItemMeta();
                                        itemMeta.setDisplayName(HexUtil.translate(this.getConfig().getString("items.artef.name")));

                                        List<String> lore = this.getConfig().getStringList("items.artef.lore");
                                        List<String> translatedLore = new ArrayList<>();
                                        for (String line : lore) {
                                            translatedLore.add(HexUtil.translate(line));
                                        }

                                        itemMeta.setLore(translatedLore);

                                        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                                        itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("artefall"), PersistentDataType.STRING, "artefall");
                                        itemStack.setItemMeta(itemMeta);
                                    } else {
                                        if (itemType.equalsIgnoreCase("artefillumandgrav")) {
                                            itemStack = new ItemStack(Material.CONDUIT);
                                            itemMeta = itemStack.getItemMeta();
                                            itemMeta.setDisplayName(HexUtil.translate(this.getConfig().getString("items.artefillumandgrav.name")));

                                            List<String> lore = this.getConfig().getStringList("items.artefillumandgrav.lore");
                                            List<String> translatedLore = new ArrayList<>();
                                            for (String line : lore) {
                                                translatedLore.add(HexUtil.translate(line));
                                            }

                                            itemMeta.setLore(translatedLore);

                                            itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                                            itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("artefillumandgrav"), PersistentDataType.STRING, "artefillumandgrav");
                                            itemStack.setItemMeta(itemMeta);
                                        } else {
                                            if (itemType.equalsIgnoreCase("artefillum")) {
                                                itemStack = new ItemStack(Material.CONDUIT);
                                                itemMeta = itemStack.getItemMeta();
                                                itemMeta.setDisplayName(HexUtil.translate(this.getConfig().getString("items.artefillum.name")));

                                                List<String> lore = this.getConfig().getStringList("items.artefillum.lore");
                                                List<String> translatedLore = new ArrayList<>();
                                                for (String line : lore) {
                                                    translatedLore.add(HexUtil.translate(line));
                                                }

                                                itemMeta.setLore(translatedLore);

                                                itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                                                itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("artefillum"), PersistentDataType.STRING, "artefillum");
                                                itemStack.setItemMeta(itemMeta);
                                            } else {
                                                if (itemType.equalsIgnoreCase("artefgrav")) {
                                                    itemStack = new ItemStack(Material.CONDUIT);
                                                    itemMeta = itemStack.getItemMeta();
                                                    itemMeta.setDisplayName(HexUtil.translate(this.getConfig().getString("items.artefgrav.name")));

                                                    List<String> lore = this.getConfig().getStringList("items.artefgrav.lore");
                                                    List<String> translatedLore = new ArrayList<>();
                                                    for (String line : lore) {
                                                        translatedLore.add(HexUtil.translate(line));
                                                    }

                                                    itemMeta.setLore(translatedLore);

                                                    itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                                                    itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("artefgrav"), PersistentDataType.STRING, "artefgrav");
                                                    itemStack.setItemMeta(itemMeta);
                                                } else {
                                                    if (itemType.equalsIgnoreCase("artefall")) {
                                                        itemStack = new ItemStack(Material.CONDUIT);
                                                        itemMeta = itemStack.getItemMeta();
                                                        itemMeta.setDisplayName(HexUtil.translate(this.getConfig().getString("items.artefall.name")));

                                                        List<String> lore = this.getConfig().getStringList("items.artefall.lore");
                                                        List<String> translatedLore = new ArrayList<>();
                                                        for (String line : lore) {
                                                            translatedLore.add(HexUtil.translate(line));
                                                        }

                                                        itemMeta.setLore(translatedLore);

                                                        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                                                        itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("artefall"), PersistentDataType.STRING, "artefall");
                                                        itemStack.setItemMeta(itemMeta);
                                                    } else {
                                                        if (itemType.equalsIgnoreCase("artefillumandender")) {
                                                            itemStack = new ItemStack(Material.CONDUIT);
                                                            itemMeta = itemStack.getItemMeta();
                                                            itemMeta.setDisplayName(HexUtil.translate(this.getConfig().getString("items.artefillumandender.name")));

                                                            List<String> lore = this.getConfig().getStringList("items.artefillumandender.lore");
                                                            List<String> translatedLore = new ArrayList<>();
                                                            for (String line : lore) {
                                                                translatedLore.add(HexUtil.translate(line));
                                                            }

                                                            itemMeta.setLore(translatedLore);

                                                            itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                                                            itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("artefillumandender"), PersistentDataType.STRING, "artefillumandender");
                                                            itemStack.setItemMeta(itemMeta);
                                                        } else {
                                                            if (itemType.equalsIgnoreCase("artefgravandender")) {
                                                                itemStack = new ItemStack(Material.CONDUIT);
                                                                itemMeta = itemStack.getItemMeta();
                                                                itemMeta.setDisplayName(HexUtil.translate(this.getConfig().getString("items.artefgravandender.name")));

                                                                List<String> lore = this.getConfig().getStringList("items.artefgravandender.lore");
                                                                List<String> translatedLore = new ArrayList<>();
                                                                for (String line : lore) {
                                                                    translatedLore.add(HexUtil.translate(line));
                                                                }

                                                                itemMeta.setLore(translatedLore);

                                                                itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                                                                itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("artefgravandender"), PersistentDataType.STRING, "artefgravandender");
                                                                itemStack.setItemMeta(itemMeta);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (itemStack != null) {
                    player.getInventory().addItem(itemStack);
                    return true;
                }

                sender.sendMessage(HexUtil.translate(this.getConfig().getString("messages.no_found_item")));
            } else {
                FileConfiguration config = this.getConfig();
                materialName = HexUtil.translate(config.getString("messages.no_found_player")).replace("{player}", playerName);
                sender.sendMessage(materialName);
            }
        }
        return true ;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("sexpitems") && sender.hasPermission("sexpitems.tab")) {
            ArrayList<String> completions = new ArrayList<>();
            if (args.length == 1) {
                completions.add("give");
                completions.add("reload");
                return completions;
            }

            if (args.length == 3 && args[0].equalsIgnoreCase("give")) {
                completions.add("illum");
                completions.add("grav");
                completions.add("artefgravandender");
                completions.add("artefillumandender");
                completions.add("artefillumandgrav");
                completions.add("artefillum");
                completions.add("artefgrav");
                completions.add("artefall");
                completions.add("artefender");
                completions.add("artef");
                completions.add("ender");
                return completions;
            }
        }

        return null;
    }
}