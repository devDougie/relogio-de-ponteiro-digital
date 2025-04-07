
import java.awt.*;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDate;
import java.time.LocalTime;

//import java.time.format.TextStyle;
//import java.util.Locale;

public class Clock extends JPanel {
    private int hours;
    private int minutes;
    private int seconds;

    private int hPointerLength = 7;
    private int mPointerLength = 10;
    private int sPointerLength = 10;

    // Método construtor
    public Clock() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalTime time = LocalTime.now();
                hours = time.getHour();
                minutes = time.getMinute();
                seconds = time.getSecond();
                repaint();
            }
        }, 0, 1000);
    }

    // Método que redesenha a tela sempre que necessário
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Definir fontes e cores para cada ponteiro
        g.setFont(new Font("Monospaced", Font.BOLD, 12));

        // Cálculo dinâmico do centro
        int localCenterX = getWidth() / 2;
        int localCenterY = getHeight() / 2;

        // Desenhar as marcações do relógio
        drawCircle(g, localCenterX, localCenterY);

        // Desenhar os ponteiros
        drawPointer(g, localCenterX, localCenterY, Color.BLACK, hPointerLength);  // Ponteiro de hora (metade do tamanho)
        drawPointer(g, localCenterX, localCenterY, Color.BLACK, mPointerLength); // Ponteiro de minuto
        drawPointer(g, localCenterX, localCenterY, Color.RED, sPointerLength);   // Ponteiro de segundo

        // Desenhar informações da data e período
        drawDateInfo(g);
    }

    // Método que desenha o ponteiro de relógio no painel
    private void drawPointer(Graphics g, int centerX, int centerY, Color pointerColor, int lengthFactor) {
        // Configurar a cor do ponteiro
        g.setColor(pointerColor);

        // Cálculo dos valores do ponteiro (hora, minuto, segundo)
        String hourString = String.format("%02d", hours);
        String minString = (minutes == 0) ? "00" : String.format("%02d", minutes);
        String secString = (seconds == 0) ? "00" : String.format("%02d", seconds);

        // Angulo para cada ponteiro
        double angle = 0;
        if (pointerColor == Color.RED && lengthFactor == sPointerLength) {
            angle = Math.toRadians(seconds * 6 - 90); // Segundo
        } else if (pointerColor == Color.BLACK && lengthFactor == hPointerLength) {
            angle = Math.toRadians(hours * 30 - 90); // Hora (30° por hora)
        } else if (pointerColor == Color.BLACK && lengthFactor == mPointerLength) {
            angle = Math.toRadians(minutes * 6 - 90); // Minuto
        }

        // Desenha o ponteiro em vários pontos ao redor do centro
        for (int i = 0; i < lengthFactor; i++) {
            int x = centerX + (int) (i * 25 * Math.cos(angle));
            int y = centerY + (int) (i * 25 * Math.sin(angle));

            if (pointerColor == Color.RED && lengthFactor == sPointerLength) { // Ponteiro de segundos
                g.drawString(secString, x, y);
            } else if (pointerColor == Color.BLACK && lengthFactor == hPointerLength) { // Ponteiro de horas
                g.drawString(hourString, x, y);
            } else if (pointerColor == Color.BLACK && lengthFactor == mPointerLength) { // Ponteiro de minutos
                g.drawString(minString, x, y);
            }
        }
    }

    // Método que desenha informações do dia/mês/ano e período
    private void drawDateInfo(Graphics g) {
        LocalDate date = LocalDate.now();
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();

        // Determina se é dia ou noite
        String period = (hours >= 6 && hours < 18) ? "Dia" : "Noite";

        // Obtém o nome do mês
        //String monthName = date.getMonth().getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));

        // Define a fonte e a cor do texto
        g.setFont(new Font("Monospaced", Font.BOLD, 14));
        g.setColor(Color.BLACK);

        // Posição no canto superior esquerdo (dia)
        g.drawString("Dia: " + String.format("%02d", day), 10, 20);

        // Posição no canto superior direito (período do dia)
        String periodText = "Período: " + period;
        int periodTextWidth = g.getFontMetrics().stringWidth(periodText);
        g.drawString(periodText, getWidth() - periodTextWidth - 10, 20);

        // Posição no canto inferior esquerdo (mês)
        g.drawString("Mês: " + String.format("%02d", month), 10, getHeight() - 20);
        //g.drawString("Mês: " + String.format("%02d", month) + " (" + monthName + ")", 10, getHeight() - 20);

        // Posição no canto inferior direito (ano)
        String yearText = "Ano: " + year;
        int yearTextWidth = g.getFontMetrics().stringWidth(yearText);
        g.drawString(yearText, getWidth() - yearTextWidth - 10, getHeight() - 20);
    }

    // Método que desenha o círculo de asteriscos ao redor do relógio
    private void drawCircle(Graphics g, int centerX, int centerY) {
        int radius = (int) ((sPointerLength + 1) * 23); // Raio um pouco maior que os ponteiros

        g.setColor(Color.BLACK);
        g.setFont(new Font("Monospaced", Font.BOLD, 14));

        for (int i = 0; i < 60; i++) {
            double angle = Math.toRadians(i * 6); // Cada asterisco a cada 6 graus
            int x = centerX + (int) (radius * Math.cos(angle));
            int y = centerY + (int) (radius * Math.sin(angle));

            g.drawString("*", x, y);
        }
    }

    // Método que é o ponto de entrada do programa
    public static void main(String[] args) {
        JFrame frame = new JFrame("Relógio de Ponteiro Digital");
        Clock panel = new Clock();

        frame.add(panel);
        frame.setSize(575, 575);  // Tamanho fixo da janela
        frame.setResizable(false); // Impede redimensionamento da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
