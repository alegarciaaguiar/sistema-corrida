# Sistema de Pagamento de Motoristas

Motor financeiro simplificado para uma plataforma de mobilidade, feito em Java usando
**herança, classe abstrata, polimorfismo (sobrescrita) e encapsulamento** — sem interfaces
e sem composição de objetos.

## Estrutura

| Classe | Papel |
|---|---|
| `Motorista` | Classe base abstrata: nome, placa, quantidade de corridas e valor bruto (todos `private`). Define `registrarCorrida` e o método abstrato `calcularPagamentoLiquido`. |
| `MotoristaIniciante` | Plataforma cobra 25%. Com menos de 5 corridas no mês, desconta taxa de inatividade de R$ 50,00. |
| `MotoristaPremium` | Plataforma cobra 15%. Sobrescreve `registrarCorrida` para somar bônus de R$ 2,00 por corrida ao bruto antes da taxa. |
| `MotoristaParceiroFrotista` | Plataforma cobra 20% e desconta R$ 800,00 de aluguel. Se o líquido ficar negativo, retorna 0,0. |
| `Main` | Simula motoristas de cada categoria e imprime o extrato de cada um. |

## Como executar

```bash
javac -d out src/*.java
java -cp out Main
```
