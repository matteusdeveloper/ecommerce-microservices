const express = require('express');
const app = express();

app.use(express.json());

app.post('/notify', (req, res) => {
    const { orderId, userId, status } = req.body;

    if (status === 'CONFIRMED') {
        console.log(`\n✅ [E-MAIL ENVIADO] Sucesso! Pedido #${orderId} confirmado para o usuário ${userId}.\n`);
        return res.status(200).json({ message: "E-mail enviado com sucesso." });
    }

    return res.status(400).json({ error: "Status inválido." });
});

const PORT = 3000;
app.listen(PORT, () => {
    console.log(`🚀 Serviço de Notificações rodando na porta ${PORT}`);
});