// Matéria: CBTLPR1 (Java) – ADS 371 – Professor: Wellington Tuler Moraes
// Nomes: Cauã Barros da Costa - Eduardo Miranda

import java.util.Scanner;
import java.text.DateFormat;
import java.util.Date;

// Criando a classe data
public class Data {
    private int dia;
    private int mes;
    private int ano;

    // Construtor com entrada de dados
    public Data() {
        entraData();
    }

    // Construtor com parâmetros
    public Data(int d, int m, int a) {
        if (validaData(d, m, a)) {
            this.dia = d;
            this.mes = m;
            this.ano = a;
        } else {
            System.out.println("Data inválida. Os valores serão inicializados com zero.");
            this.dia = 0;
            this.mes = 0;
            this.ano = 0;
        }
    }

    // Método para preencher o construtor
    private void entraData() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Digite o dia: ");
            this.dia = scanner.nextInt();
            System.out.print("Digite o mês: ");
            this.mes = scanner.nextInt();
            System.out.print("Digite o ano: ");
            this.ano = scanner.nextInt();
        } while (!validaData(this.dia, this.mes, this.ano));
    }

    // Métodos para entrada de dia mês e ano 
    public void entraDia(int d) {
        if (validaDia(d)) {
            this.dia = d;
        } else {
            System.out.println("Dia inválido.");
        }
    }

    public void entraMes(int m) {
        if (validaMes(m)) {
            this.mes = m;
        } else {
            System.out.println("Mês inválido.");
        }
    }

    public void entraAno(int a) {
        if (validaAno(a)) {
            this.ano = a;
        } else {
            System.out.println("Ano inválido.");
        }
    }

    // Métodos de retorno de dia mês e ano
    public int retDia() {
        return this.dia;
    }

    public int retMes() {
        return this.mes;
    }

    public int retAno() {
        return this.ano;
    }

    // Método que retorna a data no formato dd/mm/aaaa
    public String mostra1() {
        return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
    }

    // Método que retorna a data no formato dd/mesporextenso/ano
    public String mostra2() {
        String[] meses = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        return String.format("%02d/%s/%04d", this.dia, meses[this.mes], this.ano);
    }

    // Método que verifica se o ano é bissexto
    public boolean bissexto() {
        if ((this.ano % 4 == 0 && this.ano % 100 != 0) || this.ano % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Método que retorna a quantidade de dias transcorridos no ano até a data digitada
    public int diasTranscorridos() {
        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDias = this.dia;

        for (int i = 1; i < this.mes; i++) {
            totalDias += diasPorMes[i];
        }

        // Se for bissexto e o mês for maior que fevereiro, adiciona um dia
        if (bissexto() && this.mes > 2) {
            totalDias++;
        }

        return totalDias;
    }

    // Método que imprime a data atual 
    public void apresentaDataAtual() {
        Date dataAtual = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        String dataFormatada = dateFormat.format(dataAtual);
        System.out.println("Data atual: " + dataFormatada);
    }

    // Método privado para validação de data
    private boolean validaData(int d, int m, int a) {
        if (validaDia(d) && validaMes(m) && validaAno(a)) {
            return true;
        } else {
            return false;
        }
    }

    // Métodos privados para validar dia mês e ano
    private boolean validaDia(int d) {
        if (d > 0 && d <= 31) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validaMes(int m) {
        if (m > 0 && m <= 12) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validaAno(int a) {
        if (a > 0) {
            return true;
        } else {
            return false;
        }
    }

    // Método main para teste
    public static void main(String[] args) {

        Data data1 = new Data();
        System.out.println("Data 1 (mostra1): " + data1.mostra1());
        System.out.println("Data 1 (mostra2): " + data1.mostra2());
        System.out.println("É bissexto? " + data1.bissexto());
        System.out.println("Dias transcorridos: " + data1.diasTranscorridos());


        Data data2 = new Data(29, 2, 2020);
        System.out.println("\nData 2 (mostra1): " + data2.mostra1());
        System.out.println("Data 2 (mostra2): " + data2.mostra2());
        System.out.println("É bissexto? " + data2.bissexto());
        System.out.println("Dias transcorridos: " + data2.diasTranscorridos());
    }
}
