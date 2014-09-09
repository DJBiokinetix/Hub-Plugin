package me.DJBiokinetix;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Hub extends JavaPlugin implements Listener{

  public void onEnable(){
    saveDefaultConfig();
    getServer().getPluginManager().registerEvents(this, this);
  }
  
  @EventHandler
  public void Join(PlayerJoinEvent e){
    if (e.getPlayer().hasPermission("join.hub")){
      e.setJoinMessage(getConfig().getString("Join").replaceAll("&", "§").replaceAll("%usuario%", e.getPlayer().getName()));
      firework(e.getPlayer());
      return;
    }
    e.setJoinMessage(null);
  }
  
  @EventHandler
  public void AlSalir(PlayerQuitEvent e){
    e.setQuitMessage(null);
  }
  
  @EventHandler
  public void AlKick(PlayerKickEvent e){
    e.setLeaveMessage(null);
  }
  
  public void firework(Player player){
    Firework fw = (Firework)player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
    FireworkMeta fwmeta = fw.getFireworkMeta();
    FireworkEffect.Builder builder = FireworkEffect.builder();
    builder.withTrail().withFlicker().withFade(Color.GREEN).withColor(Color.WHITE).withColor(Color.YELLOW).withColor(Color.BLUE).withColor(Color.FUCHSIA).withColor(Color.PURPLE).withColor(Color.MAROON).withColor(Color.LIME).withColor(Color.ORANGE).with(FireworkEffect.Type.BALL_LARGE);
    fwmeta.addEffect(builder.build());
    fwmeta.setPower(1);
    fw.setFireworkMeta(fwmeta);
  }
}
