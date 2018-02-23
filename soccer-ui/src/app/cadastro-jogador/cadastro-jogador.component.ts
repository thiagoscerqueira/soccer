import { Component, OnInit } from '@angular/core';
import {Jogador} from '../model/model';
import {JogadorService} from '../service/jogador.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup, Validators, FormsModule, ReactiveFormsModule, FormBuilder} from '@angular/forms';
import {MessageService} from 'primeng/components/common/messageservice';

@Component({
  selector: 'app-cadastro-jogador',
  templateUrl: './cadastro-jogador.component.html',
  styleUrls: ['./cadastro-jogador.component.css']
})
export class CadastroJogadorComponent implements OnInit {

  jogador = new Jogador();
  fg: FormGroup;

  constructor(
    private jogadorService: JogadorService,
    private route: ActivatedRoute,
    private router: Router,
    private messageService: MessageService,
    private fb: FormBuilder) {}

  ngOnInit() {
    const idJogador = this.route.snapshot.params['id'];

    if (idJogador) {
      this.jogadorService.consultar(idJogador).subscribe(jogador => this.jogador = jogador);
    }

    this.fg = this.fb.group({
      nome: [''],
      email: ['', Validators.email]
    });
  }

  get editando() {
    return Boolean(this.jogador.id);
  }

  salvar(frm: FormControl) {
    if (this.editando) {
      this.alteraJogador();
    } else {
      this.adicionaJogador();
    }
  }

  novo(frm: FormControl) {
    frm.reset();
    this.router.navigate(['/jogadores/novo']);
  }

  private adicionaJogador() {
    this.jogadorService.adicionar(this.jogador).subscribe(jogadorAdicionado => {
      this.messageService.add({severity: 'success', summary: 'Jogador adicionado com sucesso'});
      this.router.navigate(['/jogadores', jogadorAdicionado.id]);
    });
  }

  private alteraJogador() {
    this.jogadorService.alterar(this.jogador).subscribe(jogadorAlterado => {
      this.messageService.add({severity: 'success', summary: 'Jogador alterado com sucesso'});
      this.jogador = jogadorAlterado;
    });
  }
}
