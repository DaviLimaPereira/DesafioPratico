package com.davilima.desafio.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.davilima.desafio.Model.Cliente;
import com.davilima.desafio.Model.Conteiner;
import com.davilima.desafio.Repository.ClienteRepository;
import com.davilima.desafio.Repository.ConteinerRepository;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clr;
    
    @Autowired
    private ConteinerRepository cor;

    //Método que carrega a lista de clientes cadastrados
    @RequestMapping("/clientes")
    public ModelAndView listarClientes(Model model){
        model.addAttribute("titulo", "Desafio: Clientes");
        model.addAttribute("page", "cliente/listarClientes");
        model.addAttribute("linkHome", "nav-item");
        model.addAttribute("linkCliente", "nav-item active");
        model.addAttribute("linkConteiner", "nav-item");
        ModelAndView mv = new ModelAndView("base");
        Iterable<Cliente> clientes = clr.findAll();
        mv.addObject("clientes", clientes);
        return mv;
    }

    //Método que exibe a page de Cadastro de Clientes
    @RequestMapping(value = "/cadastrarCliente", method = RequestMethod.GET)
    public String cadastrarCliente(Model model) {
        model.addAttribute("titulo", "Desafio: Cadastrar Clientes");
        model.addAttribute("page", "cliente/formCliente");
        model.addAttribute("linkHome", "nav-item");
        model.addAttribute("linkCliente", "nav-item active");
        model.addAttribute("linkConteiner", "nav-item");
        return "base";
    }

    //Método que salva o cliente no BD
    @RequestMapping(value = "/cadastrarCliente", method = RequestMethod.POST)
    public String salvarCliente(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verificar campos");
            return "redirect:/cadastrarCliente";
        }
        clr.save(cliente);
        return "redirect:/clientes";
    }

    // método que exibe a page de detalhes do cliente
    @RequestMapping(value="cliente/{id}", method=RequestMethod.GET)
    public ModelAndView detalheCliente(Model model, @PathVariable("id") long id){
        model.addAttribute("titulo", "Desafio: Detalhes do Cliente");
        model.addAttribute("page", "cliente/detalheCliente");
        model.addAttribute("linkHome", "nav-item");
        model.addAttribute("linkCliente", "nav-item active");
        model.addAttribute("linkConteiner", "nav-item");
        Cliente cliente = clr.findByIdCliente(id);
        ModelAndView mv = new ModelAndView("base");
        mv.addObject("cliente", cliente);

        Iterable<Conteiner> conteiners = cor.findByCliente(cliente);
        mv.addObject("conteiners", conteiners);

        return mv;
    }

    /*
    método que Salva os dados de Movimentação
    @RequestMapping(value="/{id}", method=RequestMethod.POST)
    public String detalheContainerPost(@PathVariable("id") long id, Movimentacao movimentacao){
        Container container = cr.findById(id);
        movimentacao.setContainer(container);
        mr.save(movimentacao);    
        return "redirect:/{id}";
    }
    usar para deletar cliente
    @RequestMapping("/deletar-container")
    public String deletarContainer(long id){
        Container container = cr.findById(id);
        cr.delete(container);
        return "redirect:/containers";
    }

    usar para deletar o conteiner e depois ajustar para deletar movimentação
    @RequestMapping("/deletar-movimentacao")
    public String deletarMovimentacao(long id){
        Movimentacao movimentacao = mr.findById(id);
        mr.delete(movimentacao);

        Container container = movimentacao.getContainer();
        long codigoLong = container.getId();
        String codigo = "" + codigoLong;
        return "redirect:/" + codigo;
    }

     */

}
