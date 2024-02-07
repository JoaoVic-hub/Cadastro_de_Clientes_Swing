/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CadastroSwingDAO;

import CadastroSwingDomain.Cliente;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author jvict
 */
public class MapClienteDAO implements IClienteDAO {
    Map <Long , String> map;
    
    public MapClienteDAO(){
        this.map = new TreeMap<>();
    }
    @Override
    public Boolean cadastrar(Cliente cliente) {
        if(map.containsKey(cliente.getCpf())){
            return false;
        }
        map.put(cliente.getCpf(), cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente cliente  = map.get(cpf);
        map.remove(cliente.getCpf(), cliente);
    }

    @Override
    public void alterar(Cliente cliente) {
        if(map.containsKey(cliente.getCpf())){
            Cliente cli = map.get(cliente.getCpf());
            cli.setCidade(cliente.getCidade());
            cli.setCpf(cliente.getCpf());
            cli.setEndereco(cliente.getEndereco());
            cli.setNome(cliente.getNome());
            cli.setTel(cliente.getTel());
            cli.setNumero(cliente.getNumero());
            cli.setEstado(cliente.getEstado());
        }
    }
    
    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }
    
}
