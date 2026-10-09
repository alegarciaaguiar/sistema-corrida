public class MotoristaParceiroFrotista extends Motorista {

    private static final double TAXA_PLATAFORMA = 0.20;
    private static final double ALUGUEL_VEICULO = 800.00;

    public MotoristaParceiroFrotista(String nome, String placaVeiculo) {
        super(nome, placaVeiculo);
    }

    @Override
    public double calcularPagamentoLiquido() {
        double pagamentoLiquido = getValorTotalBruto() * (1 - TAXA_PLATAFORMA) - ALUGUEL_VEICULO;
        return Math.max(pagamentoLiquido, 0.0);
    }

    @Override
    public String getCategoria() {
        return "Parceiro Frotista";
    }
}
