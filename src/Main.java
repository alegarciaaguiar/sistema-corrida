import java.util.List;

public class Main {

    public static void main(String[] args) {
        Motorista iniciante = new MotoristaIniciante("Carlos Souza", "ABC1D23");
        iniciante.registrarCorrida(35.00);
        iniciante.registrarCorrida(22.50);
        iniciante.registrarCorrida(48.00);

        Motorista premium = new MotoristaPremium("Mariana Lima", "XYZ9K87");
        premium.registrarCorrida(60.00);
        premium.registrarCorrida(45.00);
        premium.registrarCorrida(80.00);
        premium.registrarCorrida(30.00);

        Motorista frotistaComSaldo = new MotoristaParceiroFrotista("João Pereira", "QWE4R56");
        for (int corrida = 0; corrida < 30; corrida++) {
            frotistaComSaldo.registrarCorrida(50.00);
        }

        Motorista frotistaSemSaldo = new MotoristaParceiroFrotista("Ana Rocha", "RTY7U89");
        frotistaSemSaldo.registrarCorrida(100.00);
        frotistaSemSaldo.registrarCorrida(150.00);

        List<Motorista> motoristas = List.of(iniciante, premium, frotistaComSaldo, frotistaSemSaldo);
        imprimirExtratos(motoristas);
    }

    private static void imprimirExtratos(List<Motorista> motoristas) {
        for (Motorista motorista : motoristas) {
            System.out.println(motorista.gerarExtrato());
        }
    }
}
