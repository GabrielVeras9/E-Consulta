<%@ page import="java.util.List, br.com.consulta.entity.Usuario" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pesquisa de Usu�rios</title>
</head>
<body>
    <h1>Pesquisar Usu�rio</h1>
    
    <!-- Formul�rio para enviar a requisi��o ao servlet com o username -->
    <form action="PesquisarUsuariosServlet" method="get">
        <label for="username">Digite o Username do Usu�rio:</label>
        <input type="text" id="username" name="username" placeholder="Username"/>
        <button type="submit">Pesquisar</button>
    </form>

    <!-- Exibi��o dos resultados apenas se a pesquisa for realizada -->
    <%
        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");

        if (usuarios != null) { // S� exibe se a lista de usu�rios n�o for nula
    %>
        <h2>Resultados:</h2>
        <div>
            <%
                if (!usuarios.isEmpty()) {
                    for (Usuario usuario : usuarios) {
                        out.println("<p>ID: " + usuario.getIdUsuario() + ", Nome: " + usuario.getNomeUsuario() + ", Username: " + usuario.getUsername() + "</p>");
                    }
                } else {
                    out.println("<p>Nenhum usu�rio encontrado com esse username.</p>");
                }
            %>
        </div>
    <%
        }
    %>
</body>
</html>
