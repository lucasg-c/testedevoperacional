import java.util.List;
import java.util.Optional;

public class Autenticacao {
    List<Usuario> usuarioList;

    public Autenticacao(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Optional<Usuario> autentica(String username, String senha) {
        Optional<Usuario> optionalUsuario = usuarioList.stream().filter(u -> u.getUsername().equals(username))
                .findAny();

        if (optionalUsuario.isPresent() && optionalUsuario.get().getSenha().equals(senha)) {
            return optionalUsuario;
        } else {
            return Optional.empty();
        }
    }
}
