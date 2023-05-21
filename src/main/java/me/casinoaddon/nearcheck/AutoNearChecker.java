package me.casinoaddon.nearcheck;

import me.casinoaddon.CasinoAddon;
import me.casinoaddon.math.Vector2d;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.HashMap;

public class AutoNearChecker {
    private HashMap<String,Integer> nearByPlayers = new HashMap<String, Integer>();

    public AutoNearChecker(){
        CasinoAddon.getInstance().getApi().registerForgeListener(this);
    }


    String[] playerNameKeys = new String[0];
    String[] playerValues = new String[0];


    public String[] getPlayerNameKeys() {
        return playerNameKeys;
    }


    public HashMap<String, Integer> getNearByPlayers() {
        return nearByPlayers;
    }

    public String[] getPlayerValues() {
        return playerValues;
    }

    int ticker = 0;
    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        ticker++;
        if(ticker >=20) {
            ticker = 0;
            try {
                nearByPlayers = new HashMap<String, Integer>();
                int playersFound = 0;
                int maxPlayerListLength = 5;
                for (EntityPlayer player : Minecraft.getMinecraft().theWorld.playerEntities) {
                    if (!player.getName().equals(Minecraft.getMinecraft().thePlayer.getName())) {
                        if (playersFound >= maxPlayerListLength) {
                            break;
                        }
                        Vector2d playerXZ = new Vector2d(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY);
                        Vector2d otherPlayerXZ = new Vector2d(player.posX, player.posY);
                        if (playerXZ.getDistance(otherPlayerXZ) <= 20) {
                            nearByPlayers.put(player.getName(), (int) Minecraft.getMinecraft().thePlayer.getDistanceToEntity(player));
                            playersFound++;
                        }
                    }
                }
            }catch (Exception e){

            }
            setPlayerNameKeys();
            setPlayerDistanceValues();
        }
    }

    private void setPlayerNameKeys(){
        playerNameKeys = nearByPlayers.keySet().toArray(new String[0]);
    }

    private void setPlayerDistanceValues(){
        playerValues = new String[nearByPlayers.size()];
        int i = 0;
        for(String key : nearByPlayers.keySet()){
            playerValues[i] = nearByPlayers.get(key)+"";
            i++;
        }
    }
}
