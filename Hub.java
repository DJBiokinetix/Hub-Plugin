package me.DJBiokinetix;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Hub extends JavaPlugin implements Listener{
	
	final HashMap<Long, Long> Timer = new HashMap<Long, Long>();
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

	public void onEnable(){
    saveDefaultConfig();
    getServer().getPluginManager().registerEvents(this, this);
  }

  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	  Player jugador = (Player)sender;

      int cdt = Integer.parseInt(getConfig().getString("Time"));
      String launch = getConfig().getString("Firework message");
      String notallowed = getConfig().getString("No permission");
      String wrong = getConfig().getString("Incorrect usage");
      String wait = getConfig().getString("Wait message");

	  String leave = getConfig().getString("S Fake").replaceAll("&", "§").replaceAll("%user%", jugador.getPlayer().getName());
	  String entry = getConfig().getString("E Fake").replaceAll("&", "§").replaceAll("%user%", jugador.getPlayer().getName());
	  
	  	  if(cmd.getName().equalsIgnoreCase("rconfig")){
	  		  if(jugador.getPlayer().hasPermission("rconfig.hub")){
		      sender.sendMessage(ChatColor.GREEN + "Configuration reloaded");
		      saveDefaultConfig();
		      reloadConfig();
		  	  }}
	  	  
	  	  if(cmd.getName().equalsIgnoreCase("hub")){
	  		  jugador.sendMessage(ChatColor.DARK_GRAY + "======[" + ChatColor.GOLD + "Hub" + ChatColor.DARK_GRAY + "]======");
	  		  jugador.sendMessage(ChatColor.GRAY + "Plugin by: DJBiokinetix");
	  		  jugador.sendMessage(ChatColor.GRAY + "Version: 3.9");
	  		if (args.length == 1) {
		          if (args[0].equalsIgnoreCase("help")){
			              jugador.sendMessage(ChatColor.GREEN + "Command: /fw - Launch fireworks!");
			              jugador.sendMessage(ChatColor.GREEN + "Command: /fake - Fake message 'leave'");
			              jugador.sendMessage(ChatColor.GREEN + "Command: /entry - Fake message 'join'");
			              jugador.sendMessage(ChatColor.GREEN + "Command: /rconfig - Reload the config files!");
			              jugador.sendMessage(ChatColor.GREEN + "Command: /music - menu of the disco mode...");
			          }
			     }
	  	      }

	  	  if(cmd.getName().equalsIgnoreCase("music")){
	  		  jugador.sendMessage(ChatColor.DARK_GRAY + "======[" + ChatColor.GOLD + "Music" + ChatColor.DARK_GRAY + "]======");
	  		  jugador.sendMessage(ChatColor.RED + "/13 - Play record 13");
	  		  jugador.sendMessage(ChatColor.RED + "/cat - Play record cat");
	  		  jugador.sendMessage(ChatColor.RED + "/blocks - Play record blocks");
	  		  jugador.sendMessage(ChatColor.RED + "/chirp - Play record chirp");
	  		  jugador.sendMessage(ChatColor.RED + "/far - Play record far");
	  		  jugador.sendMessage(ChatColor.RED + "/mall - Play record mall");
	  		  jugador.sendMessage(ChatColor.RED + "/mellohi - Play record mellohi");
	  		  jugador.sendMessage(ChatColor.RED + "/stal - Play record stal");
	  		  jugador.sendMessage(ChatColor.RED + "/strad - Play record strad");
	  		  jugador.sendMessage(ChatColor.RED + "/ward - Play record ward");
	  		  jugador.sendMessage(ChatColor.RED + "/11 - Play record 11");
	  		  jugador.sendMessage(ChatColor.RED + "/wait - Play record wait");
	  		  jugador.sendMessage(ChatColor.DARK_GRAY + "===============");	
	  	  }
	  	  
	  	  if(cmd.getName().equalsIgnoreCase("fake")){
			  if(jugador.getPlayer().hasPermission("fake.hub")){
			  jugador.getServer().broadcastMessage(leave);
			  }}
	  	  
	  	  if(cmd.getName().equalsIgnoreCase("entry")){
			  if(jugador.getPlayer().hasPermission("fake.hub")){
			  jugador.getServer().broadcastMessage(entry);
			  }}
	  	  
	  	  if(cmd.getName().equalsIgnoreCase("13")){
	  		  if(jugador.getPlayer().hasPermission("13.hub")){
	  		  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2256);
	  		  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - 13");
	  		  }}
	  	
	  	  if(cmd.getName().equalsIgnoreCase("Cat")){
	  		  if(jugador.getPlayer().hasPermission("cat.hub")){
	  		  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2257);
	  		  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Cat"); 
	  		  }}
	  	
	  	  if(cmd.getName().equalsIgnoreCase("Blocks")){
	  		  if(jugador.getPlayer().hasPermission("blocks.hub")){
	  		  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2258);
	  		  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Blocks");
	  		  }}
	  	  
	  	  if(cmd.getName().equalsIgnoreCase("Chirp")){
	  		  if(jugador.getPlayer().hasPermission("chirp.hub")){
	  		  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2259); 
	  		  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Chirp");
	  		  }}
	  	  
	  	  if(cmd.getName().equalsIgnoreCase("Far")){
	  		  if(jugador.getPlayer().hasPermission("far.hub")){
	  		  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2260); 
	  		  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Far");
	  		  }}
	  	
	  	  if(cmd.getName().equalsIgnoreCase("Mall")){
	  		  if(jugador.getPlayer().hasPermission("mall.hub")){
	  		  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2261);
	  		  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Mall");
	  		  }}
	  	  
	  	  if(cmd.getName().equalsIgnoreCase("Mellohi")){
	  		  if(jugador.getPlayer().hasPermission("mellohi.hub")){
	  		  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2262);
	  		  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Mellohi");
	  		  }}
	  	  
	  	  if(cmd.getName().equalsIgnoreCase("Stal")){
	  		  if(jugador.getPlayer().hasPermission("stal.hub")){
	  		  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2263);
	  		  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Stal");
	  		  }}
	  	  
	  	  if(cmd.getName().equalsIgnoreCase("Strad")){
	  		  if(jugador.getPlayer().hasPermission("strad.hub")){
	  		  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2264);
	  		  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Strad");
	  		  }}
	  	  
	  	  if(cmd.getName().equalsIgnoreCase("Ward")){
	  		  if(jugador.getPlayer().hasPermission("ward.hub")){
	  		  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2265);
	  		  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Ward");
	  		  }}
	  	
	  	  if(cmd.getName().equalsIgnoreCase("11")){
	  		  if(jugador.getPlayer().hasPermission("11.hub")){
	  		  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2266);
	  		  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - 11");
	  		  }}
	  	  
	  	  if(cmd.getName().equalsIgnoreCase("Wait")){
	  		  if(jugador.getPlayer().hasPermission("wait.hub")){
	  		  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2267);
	  		  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Wait");
	  		  }}
	  	
	  	  if(cmd.getName().equalsIgnoreCase("stopmusic")){
	  		  if(jugador.getPlayer().hasPermission("music.hub")){
	  		  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 0);
	  		  jugador.sendMessage(ChatColor.RED + "The music has been stoped!");
	  		  }}
	  	  
	      if ((cmd.getName().equalsIgnoreCase("fw")) || (cmd.getName().equalsIgnoreCase("firework"))){
	        if (args.length == 0){
	          if (jugador.hasPermission("firework.hub")){
	            if (jugador.hasPermission("firework.admin")){
	              shootFirework(jugador);
	              jugador.sendMessage(formatVariables(launch, jugador));
	            } else {
	              int cooldownTime = cdt;
	              if (this.cooldowns.containsKey(sender.getName())){
	                long secondsLeft = ((Long)this.cooldowns.get(sender.getName())).longValue() / 1000L + cooldownTime - System.currentTimeMillis() / 1000L;
	                if (secondsLeft > 0L){
	                  sender.sendMessage(formatVariables(wait, jugador));
	                  return true;
	                }
	              }
	              this.cooldowns.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
	              shootFirework(jugador);
	              jugador.sendMessage(formatVariables(launch, jugador));
	            }
	          } else {
	            jugador.sendMessage(formatVariables(notallowed, jugador));
	          }
	        } else if (args.length == 3){
	          if (jugador.hasPermission("firework.coord")){
	            double x = Integer.parseInt(args[0]);
	            double y = Integer.parseInt(args[1]);
	            double z = Integer.parseInt(args[2]);
	            shootFirework2(jugador, x, y, z);
	            jugador.sendMessage(formatVariables(launch, jugador));
	          }
	        }
	        else if (args.length == 1) {
	          if (args[0].equalsIgnoreCase("reload")){
	            if (jugador.hasPermission("firework.admin")){
	              reloadConfig();
	              jugador.sendMessage(ChatColor.GREEN + "Configuration reloaded");
	            }
	          } else {
	            jugador.sendMessage(formatVariables(wrong, jugador));
	          }
	        }
	      }
	  return false;
	}
  
  @EventHandler
  public void Join(PlayerJoinEvent e){
    if (e.getPlayer().hasPermission("join.hub")){
      e.setJoinMessage(getConfig().getString("Join").replaceAll("&", "§").replaceAll("%user%", e.getPlayer().getName()));
      shootFirework(e.getPlayer());
      return;
    }
    e.setJoinMessage(null);
  }

  @EventHandler
  public void Leave(PlayerQuitEvent e){
	if (e.getPlayer().hasPermission("leave.hub")){
	 e.setQuitMessage(getConfig().getString("Leave").replaceAll("&", "§").replaceAll("%user%", e.getPlayer().getName()));
	 return;
	}
	e.setQuitMessage(null);
  }

  @EventHandler
  public void Kick(PlayerKickEvent e){
    e.setLeaveMessage(null);
  }

  public String formatVariables(String string, Player player){
	    int cdt = Integer.parseInt(getConfig().getString("Time"));
	    return ChatColor.translateAlternateColorCodes("&".charAt(0), string).replace("%time", String.valueOf(cdt));
	  }
	  
	  private void shootFirework(Player player){
	    Firework firework = (Firework)player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
	    FireworkMeta fm = firework.getFireworkMeta();
	    Random r = new Random();
	    FireworkEffect.Type type = null;
	    int fType = r.nextInt(5) + 1;
	    switch (fType){
	    case 1: 
	    default: 
	      type = FireworkEffect.Type.BALL;
	      break;
	    case 2: 
	      type = FireworkEffect.Type.BALL_LARGE;
	      break;
	    case 3: 
	      type = FireworkEffect.Type.BURST;
	      break;
	    case 4: 
	      type = FireworkEffect.Type.CREEPER;
	      break;
	    case 5: 
	      type = FireworkEffect.Type.STAR;
	    }
	    int c1i = r.nextInt(16) + 1;
	    int c2i = r.nextInt(16) + 1;
	    Color c1 = getColor(c1i);
	    Color c2 = getColor(c2i);
	    FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
	    fm.addEffect(effect);
	    int power = r.nextInt(2) + 1;
	    fm.setPower(power);
	    firework.setFireworkMeta(fm);
	  }
	  
	  private void shootFirework2(Player player, double x, double y, double z){
	    World world = player.getWorld();
	    double x1 = x;
	    double y1 = y;
	    double z1 = z;
	    Location loc = new Location(world, x1, y1, z1);
	    Firework firework = (Firework)player.getWorld().spawnEntity(loc, EntityType.FIREWORK);
	    FireworkMeta fm = firework.getFireworkMeta();
	    Random r = new Random();
	    FireworkEffect.Type type = null;
	    int fType = r.nextInt(5) + 1;
	    switch (fType){
	    case 1: 
	    default: 
	      type = FireworkEffect.Type.BALL;
	      break;
	    case 2: 
	      type = FireworkEffect.Type.BALL_LARGE;
	      break;
	    case 3: 
	      type = FireworkEffect.Type.BURST;
	      break;
	    case 4: 
	      type = FireworkEffect.Type.CREEPER;
	      break;
	    case 5: 
	      type = FireworkEffect.Type.STAR;
	    }
	    int c1i = r.nextInt(16) + 1;
	    int c2i = r.nextInt(16) + 1;
	    Color c1 = getColor(c1i);
	    Color c2 = getColor(c2i);
	    FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
	    fm.addEffect(effect);
	    int power = r.nextInt(2) + 1;
	    fm.setPower(power);
	    firework.setFireworkMeta(fm);
	  }
	  
	  public Color getColor(int c){
	    switch (c){
	    case 1: 
	    default: 
	      return Color.AQUA;
	    case 2: 
	      return Color.BLACK;
	    case 3: 
	      return Color.BLUE;
	    case 4: 
	      return Color.FUCHSIA;
	    case 5: 
	      return Color.GRAY;
	    case 6: 
	      return Color.GREEN;
	    case 7: 
	      return Color.LIME;
	    case 8: 
	      return Color.MAROON;
	    case 9: 
	      return Color.NAVY;
	    case 10: 
	      return Color.OLIVE;
	    case 11: 
	      return Color.ORANGE;
	    case 12: 
	      return Color.PURPLE;
	    case 13: 
	      return Color.RED;
	    case 14: 
	      return Color.SILVER;
	    case 15: 
	      return Color.TEAL;
	    case 16: 
	      return Color.WHITE;
	    }
	  }
}
