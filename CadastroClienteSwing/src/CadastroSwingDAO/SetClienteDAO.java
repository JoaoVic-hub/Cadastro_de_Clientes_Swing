/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CadastroSwingDAO;

import CadastroSwingDomain.Cliente;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jvict
 */
public class SetClienteDAO implements IClienteDAO {
    private Set <Cliente> set;

    public SetClienteDAO(){
        set = new HashSet<>();
    }
    @Override
    public Boolean cadastrar(Cliente cliente) {
        return this.set.add(cliente);
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteEncontrado = null;
        for(Cliente cliente : this.set){
            if(cpf.equals(cliente.getCpf())){
                clienteEncontrado = cliente;
                break;
            }
        }
        if(clienteEncontrado != null){
            set.remove(clienteEncontrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        for(Cliente cli : this.set){
            if(cliente.getCpf().equals(cli.getCpf())){
                cli.setNome(cliente.getNome());
                cli.setCpf(cliente.getCpf());
                cli.setTel(cliente.getTel());
                cli.setEndereco(cliente.getEndereco());
                cli.setNumero(cliente.getNumero());
                cli.setCidade(cliente.getCidade());
                cli.setEstado(cliente.getEstado());
            }
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        for(Cliente cliente : this.set){
            if(cpf.equals(cliente.getCpf())){
                return cliente;
            }
        }
        return null;
    }
}
