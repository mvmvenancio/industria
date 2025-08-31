# Projeto Java - Gestão de Funcionários (Teste Prático)

Este projeto foi desenvolvido como parte de um **teste prático de programação em Java**, simulando a gestão de funcionários em uma indústria.  
O sistema realiza operações de cadastro, remoção, agrupamento e cálculos salariais utilizando **Java Collections**, **Streams**, **LocalDate** e **BigDecimal**.

---

## 🛠️ Funcionalidades Implementadas

1. **Classe Pessoa**  
   - Atributos: `nome` (String) e `dataNascimento` (LocalDate).  

2. **Classe Funcionário (extends Pessoa)**  
   - Atributos: `salario` (BigDecimal) e `funcao` (String).  
   - Formatação de datas no padrão `dd/MM/yyyy`.  
   - Formatação de valores monetários no padrão brasileiro `#,##0.00`.  

3. **Classe Principal (Industria)** executa as seguintes ações:  

- [x] 3.1 Inserir todos os funcionários conforme a tabela inicial.  
- [x] 3.2 Remover o funcionário **"João"** da lista.  
- [x] 3.3 Imprimir todos os funcionários (com data e salário formatados).  
- [x] 3.4 Aplicar **10% de aumento salarial** a todos os funcionários.  
- [x] 3.5 Agrupar funcionários por função em um **Map** (`função -> lista de funcionários`).  
- [x] 3.6 Imprimir os funcionários agrupados por função.  
- [x] 3.8 Listar aniversariantes dos meses **outubro (10)** e **dezembro (12)**.  
- [x] 3.9 Imprimir o funcionário mais velho (nome e idade).  
- [x] 3.10 Ordenar e imprimir funcionários em **ordem alfabética**.  
- [x] 3.11 Calcular e imprimir o **total dos salários**.  
- [x] 3.12 Calcular quantos **salários mínimos** (R$ 1212,00) cada funcionário recebe.  

---

