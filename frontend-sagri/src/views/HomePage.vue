<template>
  <div class="home-container">
    <!-- Top Header -->
    <div class="top-bar">
      <img src="/logo.png" alt="SAGRI" class="logo" />
      <div class="empresa-info">
        <div>
          <span class="label">Empresa:</span> COOPERATIVA BIOJÓIAS PESCA E AGRICULTURA COOBPAGI
        </div>
        <div>
          <span class="label">Filial:</span> COOBPAGI
        </div>
      </div>
      <div class="caixa-info">
        <div>
          <span class="label">Caixa:</span> 05/03/2024
          <i class="pi pi-circle-fill green"></i>
        </div>
        <div>
          <small>O sistema expira em: 15/07/2025</small><br />
          <small>Tem 495 dias que não é feito o Backup.</small>
        </div>
      </div>
    </div>

    <!-- Menu Bar -->
    <Menubar :model="menuItems" class="menu-bar" />

    <!-- Submenu Atalhos -->
    <div class="sub-menu">
      <Button icon="pi pi-users" label="Clientes" />
      <Button icon="pi pi-chart-line" label="Fluxo de Caixa" />
      <Button icon="pi pi-wallet" label="Caixa" />
      <Button icon="pi pi-credit-card" label="Mov. Bancária" />
      <Button icon="pi pi-calendar" label="Média Diária" />
      <Button icon="pi pi-file" label="Relatórios" />
      <Button icon="pi pi-sign-out" label="Sair" severity="danger" />
    </div>

    <!-- Área Principal -->
    <div class="main-area">
      <!-- Conteúdo dinâmico futuro aqui -->
    </div>

    <!-- Rodapé -->
    <footer class="footer">
      <span>Versão: <strong>1.9.6.18</strong></span>
      <span>Usuário: <strong>CRIATIVA</strong></span>
      <span>Início Safra: 01/01/2023</span>
      <span>Final Safra: 31/12/2024</span>
      <span>Atualizado em: 20/09/2021 18:33:12</span>
      <span>Servidor: <strong>192.168.1.151</strong></span>
    </footer>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import Menubar from 'primevue/menubar'
import Button from 'primevue/button' // CORRIGIDO ✅

const menuItems = ref([
  { label: 'Arquivo' },
  { label: 'Cadastros' },
  { label: 'Movimentação' },
  { label: 'Financeiro' },
  { label: 'Utilitários' },
  { label: 'Janelas' }
])
</script>

<style scoped>
.home-container {
  display: flex;
  flex-direction: column;
  height: 100vh;
  background: linear-gradient(to right, #e6edf4, #fdfdfd);
}

.top-bar {
  display: flex;
  align-items: center;
  padding: 10px 20px;
  background: linear-gradient(to right, #002b55, #9eb6cc);
  color: white;
  font-size: 14px;
  gap: 24px;
}

.logo {
  height: 50px;
  margin-right: 20px;
}

.empresa-info,
.caixa-info {
  display: flex;
  flex-direction: column;
  gap: 4px;
}

.label {
  font-weight: bold;
}

.green {
  color: limegreen;
  font-size: 0.8rem;
  margin-left: 6px;
}

.menu-bar {
  background: #e9eef3;
  border: none;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.sub-menu {
  display: flex;
  gap: 10px;
  padding: 10px 20px;
  background-color: #f5f5f5;
  border-bottom: 1px solid #ccc;
}

.main-area {
  flex: 1;
  background-color: white;
  padding: 20px;
  overflow-y: auto;
}

.footer {
  font-size: 12px;
  color: #333;
  background-color: #e4e4e4;
  padding: 8px 20px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  gap: 10px;
  border-top: 1px solid #ccc;
}
</style>
