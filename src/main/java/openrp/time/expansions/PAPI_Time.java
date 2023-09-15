package openrp.time.expansions;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import openrp.OpenRP;
import openrp.time.utils.TimeHandler;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class PAPI_Time extends PlaceholderExpansion {

    private OpenRP plugin;

    public PAPI_Time(OpenRP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public String getAuthor() {
        return plugin.getDescription().getAuthors().toString();
    }

    @Override
    public String getIdentifier() {
        return "orptime";
    }

    @Override
    public String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Deprecated
    @Override
    public String onPlaceholderRequest(Player player, String identifier) {

        if (player == null) {
            return "";
        }

        switch (identifier) {
            default:
                if (identifier.startsWith("in_")) {
                    if (identifier.split("_").length == 3) {
                        String[] split = identifier.split(Pattern.quote("_"));
                        if (plugin.getServer().getWorld(split[1]) != null) {
                            switch (split[2]) {
                                default:
                                    return null;
                                case "second":
                                    for (TimeHandler th : plugin.getTime().getTimes()) {
                                        if (th.getWorld().getName().equals(split[1])) {
                                            String s = ((Integer) th.getSecond()).toString();
                                            s = th.getSecond() < 10 ? "0" + s : s;
                                            return s;
                                        }
                                    }
                                    return "";
                                case "minute":
                                    for (TimeHandler th : plugin.getTime().getTimes()) {
                                        if (th.getWorld().getName().equals(split[1])) {
                                            String s = ((Integer) th.getMinute()).toString();
                                            s = th.getMinute() < 10 ? "0" + s : s;
                                            return s;
                                        }
                                    }
                                    return "";
                                case "hour":
                                    for (TimeHandler th : plugin.getTime().getTimes()) {
                                        if (th.getWorld().getName().equals(split[1])) {
                                            String s = ((Integer) th.getHour()).toString();
                                            s = th.getHour() < 10 ? "0" + s : s;
                                            return s;
                                        }
                                    }
                                    return "";
                                case "day":
                                    for (TimeHandler th : plugin.getTime().getTimes()) {
                                        if (th.getWorld().getName().equals(split[1])) {
                                            String s = ((Integer) th.getDay()).toString();
                                            s = th.getDay() < 10 ? "0" + s : s;
                                            return s;
                                        }
                                    }
                                    return "";
                                case "month":
                                    for (TimeHandler th : plugin.getTime().getTimes()) {
                                        if (th.getWorld().getName().equals(split[1])) {
                                            String s = ((Integer) th.getMonth()).toString();
                                            s = th.getMonth() < 10 ? "0" + s : s;
                                            return s;
                                        }
                                    }
                                    return "";
                                case "year":
                                    for (TimeHandler th : plugin.getTime().getTimes()) {
                                        if (th.getWorld().getName().equals(split[1])) {
                                            System.out.println("WTF WHY HERE");
                                            return ((Integer) th.getYear()).toString();
                                        }
                                    }
                                    return "";
                            }
                        }
                    }
                }
                return null;
            case "world_second":
                for (TimeHandler th : plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(player.getLocation().getWorld())) {
                        String s = ((Integer) th.getSecond()).toString();
                        s = th.getSecond() < 10 ? "0" + s : s;
                        return s;
                    }
                }
                return "";
            case "world_minute":
                for (TimeHandler th : plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(player.getLocation().getWorld())) {
                        String s = ((Integer) th.getMinute()).toString();
                        s = th.getMinute() < 10 ? "0" + s : s;
                        return s;
                    }
                }
                return "";
            case "world_hour":
                for (TimeHandler th : plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(player.getLocation().getWorld())) {
                        String s = ((Integer) th.getHour()).toString();
                        s = th.getHour() < 10 ? "0" + s : s;
                        return s;
                    }
                }
                return "";
            case "world_day":
                for (TimeHandler th : plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(player.getLocation().getWorld())) {
                        String s = ((Integer) th.getDay()).toString();
                        s = th.getDay() < 10 ? "0" + s : s;
                        return s;
                    }
                }
                return "";
            case "world_month":
                for (TimeHandler th : plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(player.getLocation().getWorld())) {
                        String s = ((Integer) th.getMonth()).toString();
                        s = th.getMonth() < 10 ? "0" + s : s;
                        return s;
                    }
                }
                return "";
            case "world_year":
                for (TimeHandler th : plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(player.getLocation().getWorld())) {
                        return ((Integer) th.getYear()).toString();
                    }
                }
                return "";
            case "world_time_formatted": {
                for (TimeHandler th : plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(player.getLocation().getWorld())) {

                        int hour = th.getHour();
                        int minute = th.getMinute();

                        // Format the hour and minute into 12-hour AM/PM format
                        String timePattern = "h:mm a";
                        SimpleDateFormat sdf = new SimpleDateFormat(timePattern);
                        Date date = new Date();
                        date.setHours(hour);
                        date.setMinutes(minute);

                        return sdf.format(date);
                    }
                }
                return "";
            }
        }
    }

    @Override
    public String onRequest(OfflinePlayer player, String identifier) {

        if (player == null) {
            return "";
        }

        switch (identifier) {
            default:
                if (identifier.startsWith("in_")) {
                    if (identifier.split("_").length == 3) {
                        String[] split = identifier.split(Pattern.quote("_"));
                        if (plugin.getServer().getWorld(split[1]) != null) {
                            switch (split[2]) {
                                default:
                                    return null;
                                case "second":
                                    for (TimeHandler th : plugin.getTime().getTimes()) {
                                        if (th.getWorld().getName().equals(split[1])) {
                                            String s = ((Integer) th.getSecond()).toString();
                                            s = th.getSecond() < 10 ? "0" + s : s;
                                            return s;
                                        }
                                    }
                                    return "";
                                case "minute":
                                    for (TimeHandler th : plugin.getTime().getTimes()) {
                                        if (th.getWorld().getName().equals(split[1])) {
                                            String s = ((Integer) th.getMinute()).toString();
                                            s = th.getMinute() < 10 ? "0" + s : s;
                                            return s;
                                        }
                                    }
                                    return "";
                                case "hour":
                                    for (TimeHandler th : plugin.getTime().getTimes()) {
                                        if (th.getWorld().getName().equals(split[1])) {
                                            String s = ((Integer) th.getHour()).toString();
                                            s = th.getHour() < 10 ? "0" + s : s;
                                            return s;
                                        }
                                    }
                                    return "";
                                case "day":
                                    for (TimeHandler th : plugin.getTime().getTimes()) {
                                        if (th.getWorld().getName().equals(split[1])) {
                                            String s = ((Integer) th.getDay()).toString();
                                            s = th.getDay() < 10 ? "0" + s : s;
                                            return s;
                                        }
                                    }
                                    return "";
                                case "weekday":
                                    for (TimeHandler th : this.plugin.getTime().getTimes()) {
                                        if (th.getWorld().getName().equals(split[1])) {
                                            String s = this.plugin.getTime().getDayFromNumber(th.getDay(), th
                                                    .getMonth(), th
                                                    .getYear());
                                            return s;
                                        }
                                    }
                                    return "";
                                case "month":
                                    for (TimeHandler th : plugin.getTime().getTimes()) {
                                        if (th.getWorld().getName().equals(split[1])) {
                                            String s = ((Integer) th.getMonth()).toString();
                                            s = th.getMonth() < 10 ? "0" + s : s;
                                            return s;
                                        }
                                    }
                                    return "";
                                case "year":
                                    for (TimeHandler th : plugin.getTime().getTimes()) {
                                        if (th.getWorld().getName().equals(split[1])) {
                                            return ((Integer) th.getYear()).toString();
                                        }
                                    }
                                    return "";
                            }
                        }
                    }
                }
                return null;
            case "world_second":
                if (plugin.getServer().getPlayer(player.getName()) == null) {
                    return "";
                }
                for (TimeHandler th : plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(plugin.getServer().getPlayer(player.getName()).getLocation().getWorld())) {
                        String s = ((Integer) th.getSecond()).toString();
                        s = th.getSecond() < 10 ? "0" + s : s;
                        return s;
                    }
                }
                return "";
            case "world_minute":
                if (plugin.getServer().getPlayer(player.getName()) == null) {
                    return "";
                }
                for (TimeHandler th : plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(plugin.getServer().getPlayer(player.getName()).getLocation().getWorld())) {
                        String s = ((Integer) th.getMinute()).toString();
                        s = th.getMinute() < 10 ? "0" + s : s;
                        return s;
                    }
                }
                return "";
            case "world_hour":
                if (plugin.getServer().getPlayer(player.getName()) == null) {
                    return "";
                }
                for (TimeHandler th : plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(plugin.getServer().getPlayer(player.getName()).getLocation().getWorld())) {
                        String s = ((Integer) th.getHour()).toString();
                        s = th.getHour() < 10 ? "0" + s : s;
                        return s;
                    }
                }
                return "";
            case "world_day":
                if (plugin.getServer().getPlayer(player.getName()) == null) {
                    return "";
                }
                for (TimeHandler th : plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(plugin.getServer().getPlayer(player.getName()).getLocation().getWorld())) {
                        String s = ((Integer) th.getDay()).toString();
                        s = th.getDay() < 10 ? "0" + s : s;
                        return s;
                    }
                }
                return "";
            case "world_weekday":
                if (this.plugin.getServer().getPlayer(player.getName()) == null)
                    return "";
                for (TimeHandler th : this.plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(this.plugin.getServer().getPlayer(player.getName()).getLocation().getWorld())) {
                        String s = this.plugin.getTime().getDayFromNumber(th.getDay(), th
                                .getMonth(), th
                                .getYear());
                        return s;
                    }
                }
                return "";
            case "world_month":
                if (plugin.getServer().getPlayer(player.getName()) == null) {
                    return "";
                }
                for (TimeHandler th : plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(plugin.getServer().getPlayer(player.getName()).getLocation().getWorld())) {
                        String s = ((Integer) th.getMonth()).toString();
                        s = th.getMonth() < 10 ? "0" + s : s;
                        return s;
                    }
                }
                return "";
            case "world_year":
                if (plugin.getServer().getPlayer(player.getName()) == null) {
                    return "";
                }
                for (TimeHandler th : plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(plugin.getServer().getPlayer(player.getName()).getLocation().getWorld())) {
                        return ((Integer) th.getYear()).toString();
                    }
                }
                return "";
            case "world_time_formatted": {
                for (TimeHandler th : plugin.getTime().getTimes()) {
                    if (th.getWorld().equals(plugin.getServer().getPlayer(player.getName()).getLocation().getWorld())) {

                        int hour = th.getHour();
                        int minute = th.getMinute();

                        // Format the hour and minute into 12-hour AM/PM format
                        String timePattern = "h:mm a";
                        SimpleDateFormat sdf = new SimpleDateFormat(timePattern);
                        Date date = new Date();
                        date.setHours(hour);
                        date.setMinutes(minute);

                        return sdf.format(date);
                    }
                }
                return "";
            }
        }
    }

}
