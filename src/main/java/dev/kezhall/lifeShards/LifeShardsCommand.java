package dev.kezhall.lifeShards;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LifeShardsCommand implements CommandExecutor {

    private final LifeShards plugin;

    public LifeShardsCommand(LifeShards plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 3 || !args[0].equalsIgnoreCase("set")) {
            sender.sendMessage("§cUsage: /lifeshards set <player> <amount>");
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[1]);
        if (target == null) {
            sender.sendMessage("§cPlayer not found.");
            return true;
        }

        int amount;
        try {
            amount = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            sender.sendMessage("§cInvalid number.");
            return true;
        }

        if (amount < 1 || amount > 20) {
            sender.sendMessage("§cAmount must be between 1 and 20.");
            return true;
        }

        double newHealth = amount * 2.0;
        target.setMaxHealth(newHealth);
        if (target.getHealth() > newHealth) {
            target.setHealth(newHealth); // prevent overheal
        }

        sender.sendMessage("§aSet " + target.getName() + "'s hearts to " + amount + ".");
        target.sendMessage("§aYour max hearts were set to " + amount + "!");

        return true;
    }
}