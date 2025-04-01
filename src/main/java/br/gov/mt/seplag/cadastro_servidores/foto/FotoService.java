package br.gov.mt.seplag.cadastro_servidores.foto;

import br.gov.mt.seplag.cadastro_servidores.pessoa.Pessoa;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class FotoService {

    @Value("${minio.bucket}")
    private String bucket;

    @Autowired
    private MinioClient minioClient;

    @Autowired
    private FotoPessoaRepository fotoPessoaRepository;

    public void salvarFotoPessoa(MultipartFile file, Pessoa pessoa) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("Arquivo não pode ser nulo ou vazio");
        }

        try {
            boolean exists = minioClient.bucketExists(
                    BucketExistsArgs.builder().bucket(bucket).build()
            );
            if (!exists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao verificar/criar bucket: " + bucket, e);
        }

        String nomeArquivo = UUID.randomUUID() + "_" + file.getOriginalFilename();
        try (InputStream inputStream = file.getInputStream()) {
            PutObjectArgs args = PutObjectArgs.builder()
                    .bucket(bucket)
                    .object(nomeArquivo)
                    .stream(inputStream, file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build();

            minioClient.putObject(args);

            FotoPessoa foto = new FotoPessoa();
            foto.setPessoa(pessoa);
            foto.setData(LocalDate.now());
            foto.setBucket(bucket);
            foto.setHash(nomeArquivo);
            fotoPessoaRepository.save(foto);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar arquivo para o MinIO: " + file.getOriginalFilename(), e);
        }
    }
}