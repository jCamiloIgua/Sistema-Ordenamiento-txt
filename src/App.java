public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hola Coro!");
        for(int i=0; i<6;i++){
            System.out.println(i);
        }
        //frame
        Ventana ventana = new Ventana();
        ventana.setBounds(0, 0, 350, 250);
        ventana.setVisible(true);//Hacer visible la ventana
        ventana.setLocationRelativeTo(null);//Posicionar la ventana en el medio de la panatalla
    }
}
