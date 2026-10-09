public class MotoristaIniciante extends Motorista {

    private static final double TAXA_PLATAFORMA = 0.25;
    private static final int MINIMO_CORRIDAS_SEM_TAXA_INATIVIDADE = 5;
    private static final double TAXA_INATIVIDADE = 50.00;

    public MotoristaIniciante(String nome, String placaVeiculo) {
        super(nome, placaVeiculo);
    }

    @Override
    public double calcularPagamentoLiquido() {
        double pagamentoLiquido = getValorTotalBruto() * (1 - TAXA_PLATAFORMA);
        if (possuiPoucasCorridas()) {
            pagamentoLiquido -= TAXA_INATIVIDADE;
        }
        return pagamentoLiquido;
    }

    @Override
    public String getCategoria() {
        return "Iniciante";
    }

    private boolean possuiPoucasCorridas() {
        return getQuantidadeCorridas() < MINIMO_CORRIDAS_SEM_TAXA_INATIVIDADE;
    }
}
