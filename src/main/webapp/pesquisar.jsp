<%@ page import="java.util.List, br.com.consulta.entity.Usuario" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pesquisa de Usuários</title>
</head>
<body>
    <h1>Pesquisar Usuário</h1>
    
    <!-- Formulário para enviar a requisição ao servlet com o username -->
    <form action="PesquisarUsuariosServlet" method="get">
        <label for="username">Digite o Username do Usuário:</label>
        <input type="text" id="username" name="username" placeholder="Username"/>
        <button type="submit">Pesquisar</button>
    </form>

    <!-- Exibição dos resultados apenas se a pesquisa for realizada -->
    <%
        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");

        if (usuarios != null) { // Só exibe se a lista de usuários não for nula
    %>
        <h2>Resultados:</h2>
        <div>
            <%
                if (!usuarios.isEmpty()) {
                    for (Usuario usuario : usuarios) {
                        out.println("<p>ID: " + usuario.getIdUsuario() + ", Nome: " + usuario.getNomeUsuario() + ", Username: " + usuario.getUsername() + "</p>");
                    }
                } else {
                    out.println("<p>Nenhum usuário encontrado com esse username.</p>");
                }
            %>
        </div>
    <%
        }
    %>
</body>
</html>
