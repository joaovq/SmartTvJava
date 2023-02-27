package br.com.joaovitorqueiroz.smarttvjava;

public class Main {
    public static void main(String[] args) {
        SmartTv sala = new SmartTv("sala");
        SmartTv quarto = new SmartTv("quarto");
        Television varanda = new Television("varanda");

        sala.power();
        quarto.power();
        varanda.power();

        System.out.println(sala.getMode());
        sala.setActualChannel(3);
        System.out.println(quarto.getMode());
        quarto.setActualChannel(3);
        varanda.setActualChannel(3);

        sala.setMode(TelevisionMode.STREAMING, new User("123456","987654"));
        quarto.setMode(TelevisionMode.STREAMING, new User("123456","987654"));

        sala.disconnect();
        quarto.disconnect();

        sala.setMode(TelevisionMode.TV,null);
        quarto.setMode(TelevisionMode.TV, null);

        System.out.println(sala.getMode());
        sala.setActualChannel(7);
        System.out.println(quarto.getMode());
        quarto.setActualChannel(7);


        sala.updateLogin(new User("joaovq", "12456"));
    }
}
