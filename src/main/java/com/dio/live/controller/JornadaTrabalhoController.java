package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/*      No Framework Spring, um Controller é uma classe responsável pela preparação de um
* modelo de Map com dados a serem exibidos pela view e pela escolha da view correta. Basicamente
* ele é o responsável por controlar as requisições indicando quem deve receber as requisições e
* para quem deve responde-las.
*
*       O @RestController simplesmente retorna o objeto e os dados do objeto são gravados
* diretamente na resposta HTTP como JSON ou XML.
*
*       Isso também pode ser feito com o @Controller tradicional e o uso da anotação @ResponseBody,
* mas como esse é o comportamento padrão dos serviços RESTful, o Spring criou o @RestController
* que combina o comportamento do @Controller e do @ResponseBody.
 */

@RestController // Retorna um JSON para quem tá consumindo a API
@RequestMapping("/jornada") // Endpoint / Rota padrão
public class JornadaTrabalhoController {

    /* @RequestMapping

    *  A função do @RequestMapping é fornecer o mapeamento entre o caminho da solicitação e o método manipulador.
    *  Ele também suporta algumas opções avançadas que podem ser usadas para especificar  métodos separados
    *  para diferentes tipos de solicitação no mesmo URI. Você pode especificar um método para manipular a
    *  solicitação GET e outro para manipular a solicitação POST no mesmo URI.    *
    * */


    /* ResponseEntity
     *
     * Em situações que precisamos ter mais controle sobre a resposta HTTP em um endpoint, o próprio Spring nos
     * oferece a classe ResponseEntity que nos permite manipular os dados HTTP da resposta.
     *
     * Na prática não há diferença alguma seguindo esse exemplo. Mas, dessa maneira, seguimos um padrão que dá
     * muito mais significado para o nosso código, como também, flexibilidade para personalizar a resposta HTTP,
     * como por exemplo, devolver headers ou outros dados que fazem parte do protocolo HTTP.
     *
     * Exemplos:
     *
     *      -> responseEntity.ok() // retorna código 200
     *
     *      -> responseEntity.notFound() // retorna código 404
     * */


    @Autowired
    JornadaService jornadaService;

    // Criar uma nova jornada
    @PostMapping // caso não especifique, a rota considerada será a padrão de @RequestMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    // Exibir todas as jornadas
    @GetMapping
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaService.findAll();

    }

    // Exibir a jornada pelo ID
    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho>  getJornadaByID(@PathVariable("idJornada") Long idJornada) throws Exception {
        return  ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    // Atualizar uma jornada já existente
    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.updateJornada(jornadaTrabalho);
    }

    // Deletar uma jornada pelo ID
    @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteByID(@PathVariable("idJornada") Long idJornada) throws Exception {
       try {
           jornadaService.deleteJornada(idJornada);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();

    }



}
