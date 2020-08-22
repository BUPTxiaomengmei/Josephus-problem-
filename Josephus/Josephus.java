/*
 * ���ߣ�BUPTС����
 * 
 * ��Ŀ��Լɪ�����⡣
 * ��Ŀ������Լɪ�������Ǹ����������⣺N����Χ��һȦ���ӵ�һ����ʼ��������M������ɱ����
 * ���ʣ��һ���������˶�����ɱ��������N=6��M=5����ɱ����˳���ǣ�5��4��6��2��3��
 * 
 * ��Ŀ��չ�������������startNum����Ϸ������������ѣ������ǣ�����Ϊnumber����ʼ
 * �������˵������startNum������gameNum����֮��ͣ���ڵ�����ϵ����ų����Դ����ơ�
 * 
 * ���˼·���������������⡣
 */


package com.Josephus;

public class Josephus {

	public static void main(String[] args) {
		CreateLink link=new CreateLink();
		link.setNumber(6);//����6����
		link.setN(1);//��ʼ�������������1
		link.setM(5);//����������5
		link.SetLink();//��������
		link.show();//չʾ
		link.play();//��ʼ����
		link.show();//չʾ
	}

	
}



//��������
class Human
{
	int no;//����˵����
	Human nextHuman=null;//�����������ź����һ����
	//�������캯����Human���г�ʼ��
	public Human(int no)
	{
		this.no=no;//�������
	}
}



//����һ�����������࣬�������ó���Human
class CreateLink
{
	Human FirstHuman=null;//�������Ϊ�ʼ��FirstHuman
	Human temp;//temp������ʱʹ��
	
	int number;//�����ܹ�������
	int startNum;//���ÿ�ʼ�������˵����N
	int gameNum;//������Ϸ�е�M
	
	
	
	//��������ĳ���number
	public void setNumber(int number)
	{
		this.number=number;
	}
	//����startNum��Ҳ����N��ֵ
	public void setN(int N)
	{
		this.startNum=N;
	}
	//����gameNum��Ҳ����M��ֵ
	public void setM(int M)
	{
		this.gameNum=M;
	}
	
	
	
	//����һ�����������е�Huamn��������
	public void SetLink()
	{
		for(int i=1;i<=number;i++)//���д���Ϊnumber�ε�ѭ�������еľͶ���������
		{
			if(i==1)//����ǵ�һ��λ�ã��Ͱ�������ΪFirstHuman
			{
				Human people=new Human(i);
				this.FirstHuman=people;
				this.temp=people;
			}
			else
			{
				if(i<number)//�����2~number-1��λ�ã��ͽ�������������
				{
					Human people=new Human(i);
					temp.nextHuman=people;
					temp=people;
				}
				else//��������һ�����Ͱ�����nextHuamn����ΪFirstHuman
				{
					Human people=new Human(i);
					temp.nextHuman=people;
					temp=people;
					temp.nextHuman=this.FirstHuman;
				}
			}
		}
	}
	
	
	
	//��Ϸ��ʼ�ĺ���
	public void play()
	{
		//����Ҫ�ҵ���ʼ�������˵���ţ�����forѭ������
		this.temp=this.FirstHuman;
		for(int i=1;i<this.startNum;i++)//ѭ��������N-1
		{
			this.temp=this.temp.nextHuman;
		}
		do {
			//��ʼ����M�������ҵ��ų����˵����
			for(int j=1;j<this.gameNum;j++)//ѭ��������M-1
			{
				this.temp=this.temp.nextHuman;
			}
			System.out.println("Ҫ���ų�����������"+temp.no);
			//���������ų����⣬��Խ����������������
			Human temp1=temp;
			while(temp.nextHuman!=temp1)
			{
				temp=temp.nextHuman;
			}
			temp.nextHuman=temp1.nextHuman;
			temp=temp.nextHuman;
			this.number--;//���ʣ��Human����Ŀ����1�����
		}while(this.number!=1);
	}
	
	
	
	//����һ��������ӡ��������
	public void show()
	{
		Human people= this.FirstHuman;
		do 
		{
			System.out.println(people.no);
			people=people.nextHuman;
		}while(people!=this.FirstHuman);
	}
}