package us.lupusbukkit.GuestGuard;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
 
public class GuestGuard extends JavaPlugin implements Listener {
    boolean stopChat = this.getConfig().getBoolean("stopChat");
    boolean stopPlace = this.getConfig().getBoolean("stopPlace");
    boolean stopBreak = this.getConfig().getBoolean("stopBreak");
    @Override
    public void onDisable(){
       
        System.out.println(this + " is now disabled!");
    }
    @Override
        public void onEnable(){
        getServer().getPluginManager().registerEvents(this, this);
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    @EventHandler
    public void StopPlace(BlockPlaceEvent event){
        Player player = event.getPlayer();
        if(stopPlace) {
        if(!player.hasPermission("guestguard.build")) {
        event.setCancelled(true);
        player.sendMessage(ChatColor.RED+"You cannot place blocks!");
        }
        }
        }
    @EventHandler
    public void StopChat(PlayerChatEvent event){
        Player player = event.getPlayer();
        if(stopChat) {
        if(!player.hasPermission("guestguard.chat")) {
        event.setCancelled(true);
        player.sendMessage(ChatColor.RED+"You cannot chat!");
        }
        }
    }
    @EventHandler
    public void StopBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        if(stopBreak){
        if(!player.hasPermission("guestguard.build")) {
        event.setCancelled(true);
        player.sendMessage(ChatColor.RED+"You cannot destroy blocks!");
        }
        }
    }
    }