#include <stdio.h>
#include <math.h>

int main()
{
	int n;
	scanf ("%d", &n);
	while (n--)
	{
		double a, b, c;
		double x1, x2;
		scanf("%lf %lf %lf", &a, &b, &c);
		double delta = b*b-4*a*c;
		if (delta > 0)
		{
			x1 = (-b + sqrt(delta))/(2*a);
			x2 = (-b - sqrt(delta))/(2*a);
			printf("x1=%.5lf;x2=%.5lf\n", x1, x2);
		}
		else if (fabs(delta) < 1e-8)// ��double��������ֵ��С��С���������ȷ�Χ��ʱ�����Ǿ���Ϊ������
		{
			x1 = -b / (2 * a);
			printf("x1=x2=%.5lf\n", x1);
		}
		else
		{
			delta = 0 - delta;// �Ը���delta����ȡ��
			double p = -b / (2 * a);
			double q = sqrt(delta) / (2 * a);
			if (fabs(p) < 1e-8) p = 0.0;// �Ը�����
			printf("x1=%.5lf+%.5lfi;x2=%.5lf-%.5lfi\n", p, q , p, q);
		}
	}
	return 0;
}
