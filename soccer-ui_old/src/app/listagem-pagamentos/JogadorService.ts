import {Injectable} from '@angular/core';
import {Jogador} from '../model/Jogador';
import {Pagamento} from '../model/Pagamento';

@Injectable()
export class JogadorService {

  salvar(jogador: Jogador) {
    let jogadores: Jogador[] = JSON.parse(localStorage.getItem('jogadores'));
    console.log(jogadores);
    if (jogadores == null) {
      jogadores = [];
    }

    jogador.id = this.guid();

    jogadores = jogadores.filter( i => i.id !== jogador.id);
    jogadores.push(jogador);

    localStorage.setItem('jogadores', JSON.stringify(jogadores));
  }

  limpar() {
    localStorage.setItem('jogadores', JSON.stringify([]));
  }

  guid() {
    function s4() {
      return Math.floor((1 + Math.random()) * 0x10000)
        .toString(16)
        .substring(1);
    }

    return s4() + s4() + '-' + s4() + '-' + s4() + '-' +
      s4() + '-' + s4() + s4() + s4();
  }
}
