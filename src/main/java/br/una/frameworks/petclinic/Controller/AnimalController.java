package br.una.frameworks.petclinic.Controller;

import br.una.frameworks.petclinic.entity.Animal;
import br.una.frameworks.petclinic.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/")
    public String listar(Model model) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("animais", animalRepository.findAll());
        return "animal/listar";
    }

    @GetMapping("/{id}")
    public String editar(Model model, @PathVariable Long id) {
        model.addAttribute("animal", animalRepository.findOne(id));
        model.addAttribute("animais", animalRepository.findAll());
        return "animal/listar";
    }

    @GetMapping("/buscar")
    public String buscar(Model model, @RequestParam String nome) {
        model.addAttribute("animal", new Animal());
        model.addAttribute("animais", animalRepository.findByNomeLike("%" + nome + '%'));
        return "animal/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        animalRepository.delete(id);
        return "redirect:/";
    }

    @PostMapping("/")
    public String salvar(@Valid @ModelAttribute Animal animal,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "animal/listar";
        }
        animalRepository.save(animal);
        return "redirect:/";
    }

}
