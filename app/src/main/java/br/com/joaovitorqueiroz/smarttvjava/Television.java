package br.com.joaovitorqueiroz.smarttvjava;

import java.util.ArrayList;

public class Television{
    private String room;
    private final ArrayList<Integer> channels = new ArrayList<Integer>(){{
        add(1);
        add(3);
        add(5);
        add(7);
        add(11);
    }};
    private boolean isOn = false;

    private int volume = 0;

    public int getVolume() {
        return volume;
    }

    public Television(String room) {
        this.room = room;
    }

    private int actualChannel = 1;

    public void setActualChannel(int chooseChannel){
        if (chooseChannel == actualChannel){
            System.out.println("Você ja esta nesse canal");
        } else if (isOn && channels.contains(chooseChannel)){
            this.actualChannel = chooseChannel;
            System.out.println("Canal trocado para "+ chooseChannel+"na do "+room);
        } else {
            System.out.println("Algo deu errado!!" +
                    " verifique se a tv está ligada ou se o canal é válido");

            System.out.println("A tv está ligada? :" +room+" - "+ isOn);
            System.out.println("O canal é válido? :" +room+" - "+ chooseChannel);

        }
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public ArrayList<Integer> getChannels() {
        return channels;
    }

    public boolean isOn() {
        return isOn;
    }

    public void power() {
        isOn = !isOn;
        if (isOn){
            System.out.println("A tv está ligada: " +room);
        } else {
            System.out.println("A tv está desligada: " +room);

        }
    }

    public int getActualChannel() {
        return actualChannel;
    }

    public void increaseVolume(){
        if (volume<100){
            volume++;
            System.out.println("Aumentando volume: "+room+" - "+volume);
        } else {
            System.out.println("O volume ja esta no maximo: "+room+" - "+volume);

        }
    }
    public void decreaseVolume(){
        if (volume>0){
            volume--;
            System.out.println("Diminuindo volume: "+room+" - "+volume);
        } else {
            System.out.println("O volume ja esta no minimo: "+room+" - "+volume);
        }
    }

}
