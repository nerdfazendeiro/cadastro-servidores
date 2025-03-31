package br.gov.mt.seplag.cadastro_servidores.endereco;

public record DadosEndereco(String tipo_logradouro, String logradouro, int numero, String bairro, DadosCidade cidade) {
}
