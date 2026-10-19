async function carregarContatos(){
    const response = await fetch('/api/contatos');
    const contatos = await response.json();
    const body = document.getElementById('tabela-contatos');
    
}