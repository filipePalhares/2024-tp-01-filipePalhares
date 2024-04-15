public class Cliente {

    ////////////////////////////////////// Variaveis:

    private String nome;
    private String cpf;
    private String endereco;
    private int idade;
    private char sexo;

    ////////////////////////////////////// inicializacao:

    public static Cliente criarCliente(String nome, String cpf, String endereco, int idade, char sexo)
    {
        Cliente p = new Cliente();

        if(verfCpf(cpf) == true)
        {
            p.nome = nome;
            p.cpf = cpf;
            p.endereco = endereco;
            p.idade = idade;
            p.sexo = sexo;
        }
        else
        {
            p = null;
        }

        return p;
    }

    ////////////////////////////////////// Getter e Setter:

    /////////////////// get e set - nome:

    public String getNome() {return this.nome;}
    public void setNome(String str) {this.nome = str;}

    /////////////////// get - cpf:

    public String getCpf() {return this.cpf;}

    /////////////////// get e set - endereco:

    public String getEndereco() {return this.endereco;}
    public void setEndereco(String str) {this.endereco = str;}

    /////////////////// get e set - idade:

    public int getIdade() {return this.idade;}
    public void setIdade(int n) {this.idade = n;}

    /////////////////// get e set - sexo:

    public char getSexo() {return this.sexo;}
    public void setSexo(char c) {this.sexo = c;}

    ////////////////////////////////////// Verifica se o cpf e valido:

    private static boolean verfCpf(String cpf)
    {
        boolean cpfValido = true;
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() != 11)
            cpfValido = false;

        // Verifica se todos os dígitos são iguais
        boolean allDigitsEqual = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                allDigitsEqual = false;
                break;
            }
        }
        if (allDigitsEqual)
            cpfValido = false;

        // Calcula o primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digit1 = 11 - (sum % 11);
        if (digit1 > 9)
            digit1 = 0;

        // Verifica o primeiro dígito verificador
        if ((cpf.charAt(9) - '0') != digit1)
            cpfValido = false;

        // Calcula o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digit2 = 11 - (sum % 11);
        if (digit2 > 9)
            digit2 = 0;

        // Verifica o segundo dígito verificador
        if ((cpf.charAt(10) - '0') != digit2)
            cpfValido = false;

        if(cpfValido) System.out.println("CPF Válido");
        else System.out.println("CPF Inválido");

        return cpfValido;
    }

}
