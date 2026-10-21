const API_URL = `${window.CONTEXT_PATH}/api/contatos`;
function escapeHtml(valor) {
    const mapa = { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;' };
    return String(valor ?? '').replace(/[&<>"']/g, ch => mapa[ch]);
}
async function carregarContatos(){
    const response = await fetch('/api/contatos');
    const contatos = await response.json();
    const tbody = document.getElementById('tabela-contatos');

    tbody.innerHTML = contatos.map(c => ``).join('');{
        
    }
}