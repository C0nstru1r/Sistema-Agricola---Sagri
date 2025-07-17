<template>
  <div class="principal-container">
    <!-- Topo com logo e informações -->
    <header class="top-bar">
      <img src="/logo-sagri.png" alt="Logo" class="logo" />
      <div class="top-info">
        <div><strong>Empresa:</strong> COOPERATIVA BIOJOIAS PESCA E AGRICULTURA COOBPAGI</div>
        <div><strong>Filial:</strong> COOBPAGI</div>
        <div>
          <strong>Caixa:</strong> 05/03/2024
          <span class="status-dot" />
        </div>
        <div class="data-sistema">Ituberá, Domingo, 13 de Julho de 2025</div>
      </div>
    </header>

    <!-- Menubar -->
    <Menubar :model="menuItems" />

    <!-- Sub-menu com botões -->
    <div class="button-bar">
      <Button label="Clientes" icon="pi pi-users" />
      <Button label="Fluxo de Caixa" icon="pi pi-chart-line" />
      <Button label="Caixa" icon="pi pi-wallet" />
      <Button label="Movimentação Bancária" icon="pi pi-sync" />
      <Button label="Média Diária" icon="pi pi-calendar" />
      <Button label="Relatórios" icon="pi pi-file" />
      <Button label="Sair" icon="pi pi-sign-out" severity="danger" />
    </div>

    <!-- Área principal -->
    <main class="conteudo-principal">
      <p>Aqui vai o conteúdo principal...</p>
    </main>

    <!-- Rodapé -->
    <footer class="rodape">
      <div>
        <strong>Versão:</strong> 1.9.6.18 | <strong>Usuário:</strong> CRIATIVA | Início Safra: 01/01/2023 | Final Safra: 31/12/2024
      </div>
      <div>
        Atualizado em: 20/09/2021 18:33:12 | IP: 192.168.1.151 | Usuário: Elismar_Santos | Banco: SAGRI/DADOS/BASE.FDB
      </div>
    </footer>
  </div>
</template>

<script setup>
import Menubar from 'primevue/menubar'
import Button from 'primevue/button' // CORRIGIDO ✅

const menuItems = [
  { label: 'Arquivo' },
  { label: 'Cadastros' },
  { label: 'Movimentação' },
  { label: 'Financeiro' },
  { label: 'Utilitários' },
  { label: 'Janelas' }
]
</script>

<style scoped>
.principal-container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  font-family: sans-serif;
}

.top-bar {
  display: flex;
  align-items: center;
  padding: 12px;
  background: linear-gradient(to right, #00334d, #d9e2ef);
  color: #fff;
}

.logo {
  width: 80px;
  margin-right: 16px;
}

.top-info {
  display: flex;
  flex-direction: column;
  color: #fff;
}

.status-dot {
  display: inline-block;
  width: 10px;
  height: 10px;
  background-color: green;
  border-radius: 50%;
  margin-left: 4px;
}

.data-sistema {
  font-size: 14px;
  margin-top: 4px;
}

.button-bar {
  display: flex;
  gap: 8px;
  padding: 10px;
  background-color: #f3f3f3;
  border-bottom: 1px solid #ccc;
}

.conteudo-principal {
  flex-grow: 1;
  padding: 20px;
  background-color: #fff;
}

.rodape {
  font-size: 12px;
  background-color: #eaeaea;
  padding: 10px;
  border-top: 1px solid #ccc;
}
</style>