package com.dio.live.service;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // INdica que esta classe é responsável pela lógica de negócios Anotação que indica o SERVICE (padrão MVC).
public class JornadaService {

/* @Service
*
* Marcamos beans com @Service para indicar que ele está mantendo a LÓGICA DE NEGÓCIOS.
* Faz anotações na camada de serviços.
* Não há outra especialidade, além do uso na camada de serviço. *
*
**/

    JornadaRepository jornadaRepository;

    /* @Autowired
     *
     * No Spring, para marcar os pontos de injeção dentro da sua classe, você utiliza a anotação @Autowired.
     *
     * Dessa forma nós conseguimos programar voltados para interfaces e, com isso, manter o baixo acoplamento
     * entre as classes de um mesmo projeto.
     *
     * Injeção de dependências (ou Dependency Injection – DI) é um tipo de inversão de controle
     * (ou Inversion of Control – IoC) que dá nome ao processo de prover instâncias de classes
     * que um objeto precisa para funcionar. Para manter o conceito de injeção não podemos utilizar
     * a palavra reservada new. Exemplo: Aluno aluno = new Aluno();
     *
     * Você pode utilizar essa anotação em:
     *
     *     -> Propriedades;
     *     -> Construtores;
     *     -> Métodos (mais comumente, os setters)
     *
     *  @Autowired é mais comum de ser utilizado no Construtor.         *
     *
     *  O que torna uma classe elegível de ser injetada?
     *
     *  Para que uma instância do tipo 'ClienteRepositorio' possa ser injetada em algum dos pontos de injeção,
     *  é preciso que ela se torne um bean Spring. Fazemos isso anotando ela com a anotação @Component ou com
     *  qualquer uma de suas especializações: @Repository, @Service ou @Controller.
     *
     **/

    @Autowired // Injeção de dependência passando jornadaRepository como parâmetro no Construtor da classe JornadaService
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    // Método para salvar uma jornada de usuário
    public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho){
       return jornadaRepository.save(jornadaTrabalho);

    }

    // Método para retornar todas as jornadas
    public List<JornadaTrabalho> findAll() {
       return   jornadaRepository.findAll();
    }

    // Método para retornar uma jornada pelo seu ID
    public Optional<JornadaTrabalho> getById(Long idJornada) {
        return jornadaRepository.findById(idJornada);
    }

    // Método para atualizar uma jornada existente
    public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);

    }

    // Deleter uma jornada pelo seu ID
    public void deleteJornada(Long idJornada) {
        jornadaRepository.deleteById(idJornada);
    }
}
