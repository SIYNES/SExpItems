package org.siynes.sexpitems.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.Nullable;

public final class HexUtil {
    public static @Nullable String translate(String message) {
        Pattern pattern = Pattern.compile("&#([A-Fa-f0-9]{6})");

        String color;
        String replacement;
        for(Matcher matcher = pattern.matcher(message); matcher.find(); message = message.replace("&#" + color, replacement)) {
            color = matcher.group(1);
            replacement = ChatColor.of("#" + color).toString();
        }

        message = message.replace("\n", "\n");
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}