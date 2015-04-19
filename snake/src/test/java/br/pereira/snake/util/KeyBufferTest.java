package br.pereira.snake.util;

import org.junit.Assert;
import org.junit.Test;

public class KeyBufferTest {
	
	@Test
	public void quando_capacidade_um_adicionar_um_item_e_depois_remove_lo_buffer_deve_ficar_vazio() {
		KeyBuffer buffer = new KeyBuffer(1);
		
		buffer.add(8);
		Assert.assertEquals(1, buffer.length());
		
		int value = buffer.get();
		Assert.assertEquals(8, value);
		Assert.assertEquals(0, buffer.length());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void quando_iniciar_com_zero_nao_permitir() {
		new KeyBuffer(0);
		Assert.fail();
	}
	
	@Test
	public void quando_adicionar_alem_da_capacidade_nao_fazer_nada() {
		KeyBuffer buffer = new KeyBuffer(1);
		
		buffer.add(8);
		Assert.assertEquals(1, buffer.length());
		
		buffer.add(9);
		Assert.assertEquals(1, buffer.length());
		
		int value = buffer.get();
		Assert.assertEquals(8, value);
		Assert.assertEquals(0, buffer.length());
	}
	
	@Test
	public void quando_adicionar_tres_itens_remover_dois_adicionar_mais_dois_e_retirar_todos() {
		KeyBuffer buffer = new KeyBuffer(3);
		
		buffer.add(1);
		buffer.add(2);
		buffer.add(3);
		
		Assert.assertEquals(3, buffer.length());
		
		Assert.assertEquals(1, buffer.get());
		Assert.assertEquals(2, buffer.get());
		
		Assert.assertEquals(1, buffer.length());
		
		buffer.add(4);
		buffer.add(5);
		
		Assert.assertEquals(3, buffer.length());
		
		Assert.assertEquals(3, buffer.get());
		Assert.assertEquals(4, buffer.get());
		Assert.assertEquals(5, buffer.get());
	}
	

}
