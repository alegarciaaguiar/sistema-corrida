import java.util.Locale;

public abstract class Motorista {

    private static final Locale LOCALE_BRASIL = Locale.forLanguageTag("pt-BR");

    private final String nome;
    private final String placaVeiculo;
    private int quantidadeCorridas;
    private double valorTotalBruto;

    protected Motorista(String nome, String placaVeiculo) {
        validarTextoObrigatorio(nome, "Nome do motorista");
        validarTextoObrigatorio(placaVeiculo, "Placa do veículo");
        this.nome = nome;
        this.placaVeiculo = placaVeiculo;
        this.quantidadeCorridas = 0;
        this.valorTotalBruto = 0.0;
    }

    public void registrarCorrida(double valorCorrida) {
        if (valorCorrida <= 0) {
            throw new IllegalArgumentException("O valor da corrida deve ser maior que zero.");
        }
        quantidadeCorridas++;
        valorTotalBruto += valorCorrida;
    }

    public abstract double calcularPagamentoLiquido();

    public abstract String getCategoria();

    public String gerarExtrato() {
        return "========================================\n"
                + "        EXTRATO MENSAL DO MOTORISTA\n"
                + "========================================\n"
                + "Categoria ........: " + getCategoria() + "\n"
                + "Nome .............: " + nome + "\n"
                + "Placa ............: " + placaVeiculo + "\n"
                + "Corridas no mês ..: " + quantidadeCorridas + "\n"
                + "Valor bruto ......: " + formatarMoeda(valorTotalBruto) + "\n"
                + "Valor líquido ....: " + formatarMoeda(calcularPagamentoLiquido()) + "\n"
                + "========================================\n";
    }

    public String getNome() {
        return nome;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public int getQuantidadeCorridas() {
        return quantidadeCorridas;
    }

    public double getValorTotalBruto() {
        return valorTotalBruto;
    }

    private static String formatarMoeda(double valor) {
        return String.format(LOCALE_BRASIL, "R$ %,.2f", valor);
    }

    private static void validarTextoObrigatorio(String texto, String nomeDoCampo) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(nomeDoCampo + " é obrigatório.");
        }
    }
}
