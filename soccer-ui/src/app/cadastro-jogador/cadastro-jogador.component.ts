import { Component, OnInit } from '@angular/core';
import {Jogador} from '../model/model';
import {JogadorService} from '../service/jogador.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-cadastro-jogador',
  templateUrl: './cadastro-jogador.component.html',
  styleUrls: ['./cadastro-jogador.component.css']
})
export class CadastroJogadorComponent implements OnInit {

  jogador = new Jogador();

  constructor(
    private jogadorService: JogadorService,
    private route: ActivatedRoute,
    private router: Router) {}

  ngOnInit() {
    const idJogador = this.route.snapshot.params['id'];

    if (idJogador) {
      this.jogadorService.consultar(idJogador).subscribe(jogador => this.jogador = jogador);
    }
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
      this.router.navigate(['/jogadores'], jogadorAdicionado.id);
    });
  }

  private alteraJogador() {
    this.jogadorService.alterar(this.jogador).subscribe(jogadorAlterado => {
      this.jogador = jogadorAlterado;
    });
  }
}
