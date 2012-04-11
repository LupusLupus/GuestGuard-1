package us.lupusbukkit.GuestGuard;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;
 
public class GuestGuard extends JavaPlugin implements Listener {
    public void onDisable(){
       
        System.out.println(this + " is now disabled!");
    }
    @Override
        public void onEnable(){
        getServer().getPluginManager().registerEvents(this, this);
    }
    @EventHandler
    public void StopPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if(!player.hasPermission("guestguard.build")) {
        event.setCancelled(true);
        player.sendMessage(ChatColor.RED+"You cannot place blocks!");
        }
        }
    @EventHandler
    public void StopChat(PlayerChatEvent event){
        Player player = event.getPlayer();
        if(!player.hasPermission("guestguard.chat")) {
        event.setCancelled(true);
        player.sendMessage(ChatColor.RED+"You cannot chat!");
        }
    }
    @EventHandler
    public void StopBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(!player.hasPermission("guestguard.build")) {
        event.setCancelled(true);
        player.sendMessage(ChatColor.RED+"You cannot destroy blocks!");
        }
    }
    }