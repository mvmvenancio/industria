package industria;
import java.util.*;

import java.time.LocalDate;
import java.math.BigDecimal;

// 1
class Pessoa {
    public String nome;
    public LocalDate nascimento;

    public int getIdade() {
        return java.time.Period.between(nascimento, LocalDate.now()).getYears();
    }
}
// 2
class Funcionario  extends Pessoa{
    public BigDecimal salario;
    public String func;

    public Funcionario(String nome, LocalDate nascimento, BigDecimal salario, String func) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.salario = salario;
        this.func = func;
    }
    
    @Override
    public String toString() {
        java.time.format.DateTimeFormatter dateFormatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
        java.text.DecimalFormat decimalFormatter = new java.text.DecimalFormat("#,##0.00");
        java.text.DecimalFormatSymbols symbols = new java.text.DecimalFormatSymbols(new java.util.Locale("pt", "BR"));
        decimalFormatter.setDecimalFormatSymbols(symbols);

        return "Nome: " + nome + ", Data de Nascimento: " + nascimento.format(dateFormatter) +
               ", Salário: R$ " + decimalFormatter.format(salario) + ", Função: " + func;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }
}
// 3
public class Industria {
    public static void main(String[] args) {
        // 3.1
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
        // 3.2 - Remover o funcionário “João” da lista.
        funcionarios.removeIf(funcionario -> funcionario.nome.equals("João"));
        // 3.3 - Imprimir todos os funcionários com todas suas informações
        System.out.println("\n--- Todos os Funcionários (após remoção de João) ---");
        funcionarios.forEach(System.out::println);
        // 3.4 - Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        funcionarios.forEach(funcionario -> funcionario.salario = funcionario.salario.multiply(new BigDecimal("1.10")));
        System.out.println("\n--- Funcionários com 10% de aumento de salário ---");
        funcionarios.forEach(System.out::println);
        // 3.5 - Agrupar os funcionários por função em um MAP
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(java.util.stream.Collectors.groupingBy(f -> f.func));
        // 3.6 - Imprimir os funcionários, agrupados por função.
        System.out.println("\n--- Funcionários agrupados por função ---");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(System.out::println);
            System.out.println();
        });
        // 3.8 - Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("--- Aniversariantes de Outubro e Dezembro ---");
        funcionarios.stream()
                .filter(funcionario -> funcionario.nascimento.getMonthValue() == 10 || funcionario.nascimento.getMonthValue() == 12)
                .forEach(System.out::println);
        // 3.9 - Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        System.out.println("\n--- Funcionário com a maior idade ---");
        funcionarios.stream()
                .min(java.util.Comparator.comparing(Funcionario::getNascimento))
                .ifPresent(funcionario -> System.out.println("Nome: " + funcionario.nome + ", Idade: " + funcionario.getIdade() + " anos"));
        // 3.10 - Imprimir a lista de funcionários por ordem alfabética.
        System.out.println("\n--- Funcionários em ordem alfabética ---");
        funcionarios.stream()
                .sorted(java.util.Comparator.comparing(f -> f.nome))
                .forEach(System.out::println);
        // 3.11 - Imprimir o total dos salários dos funcionários.
        System.out.println("\n--- Total dos Salários dos Funcionários ---");
        BigDecimal totalSalarios = funcionarios.stream()
                .map(f -> f.salario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total de salários: R$ " + new java.text.DecimalFormat("#,##0.00", new java.text.DecimalFormatSymbols(new java.util.Locale("pt", "BR"))).format(totalSalarios));
        // 3.12 - Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        System.out.println("\n--- Salários Mínimos por Funcionário ---");
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        funcionarios.forEach(funcionario -> {
            BigDecimal salariosMinimos = funcionario.salario.divide(salarioMinimo, 2, java.math.RoundingMode.HALF_UP);
            System.out.println(funcionario.nome + ": " + salariosMinimos + " salários mínimos");
        });
    }
}