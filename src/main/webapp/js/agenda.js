const API_URL = `${window.CONTEXT_PATH}/api/contatos`;
function escapeHtml(valor) {
    const mapa = { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;' };
    return String(valor ?? '').replace(/[&<>"']/g, ch => mapa[ch]);
}
async function carregarContatos(){
    const response = await fetch(`${API_URL}`);
    const contatos = await response.json();
    const tbody = document.getElementById('tabela-contatos');
    tbody.innerHTML = '';
    tbody.innerHTML += contatos.map(c => `
        <tr>
            <td>${escapeHtml(c.id)}</td>
            <td>${escapeHtml(c.nome)}</td>
            <td>${escapeHtml(c.telefone)}</td>
            <td>${escapeHtml(c.email)}</td>
            <td>
                <a href="${window.CONTEXT_PATH}/editar-contato?id=${c.id}" class="btn btn-sm btn-warning">Editar</a>
                <button type="button" class="btn btn-sm btn-danger" onclick="excluirContato('${encodeURIComponent(c.id)}')">Excluir</button>
            </td>
        </tr>
        `).join('');{
    }
}

async function excluirContato(id) {
    if (!confirm('Tem certeza que deseja excluir este contato?')) {
        return;
    }
    await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
    carregarContatos();
}
document.addEventListener('DOMContentLoaded', carregarContatos);
