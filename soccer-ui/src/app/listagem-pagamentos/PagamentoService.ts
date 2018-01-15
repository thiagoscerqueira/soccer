import {Injectable} from '@angular/core';
import {Jogador} from '../model/Jogador';
import {Pagamento} from '../model/Pagamento';

@Injectable()
export class PagamentoService {


  salvar(pagamento: Pagamento) {
    let pagamentos: Pagamento[] = JSON.parse(localStorage.getItem('pagamentos'));

    if (pagamentos == null) {
      pagamentos = [];
    }

    pagamentos = pagamentos.filter( i => i.id !== pagamento.id);
    pagamentos.push(pagamento);

    localStorage.setItem('pagamentos', JSON.stringify(pagamentos));
  }

  limpar() {
    localStorage.setItem('pagamentos', JSON.stringify([]));
  }

  pesquisar(date: Date) {
    let pagamentos: Pagamento[] = JSON.parse(localStorage.getItem('pagamentos'));

    if (pagamentos == null) {
      pagamentos = [];
    }
    pagamentos = pagamentos.filter(i => i.mes === date);

    let jogadores: Jogador[] = JSON.parse(localStorage.getItem('jogadores'));
    if (jogadores == null) {
      jogadores = [];
    }

    jogadores = jogadores.filter(i => !pagamentos.some(j => j.jogador.id === i.id));
    jogadores.forEach(i => pagamentos.push(new Pagamento(this.guid(), date, i, 0)));

    return pagamentos;
  }

  excluir(pagamento: Pagamento) {
    let pagamentos: Pagamento[] = JSON.parse(localStorage.getItem('pagamentos'));

    if (pagamentos == null) {
      pagamentos = [];
    }

    pagamentos = pagamentos.filter(i => i.id !== pagamento.id);
    localStorage.setItem('pagamentos', JSON.stringify(pagamentos));
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
