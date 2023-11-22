#include <stdio.h>
#include <stdbool.h>

int findOptimal(int pages[], int n, int frame[], int m, int index) {
	int res = -1, farthest = index;
	for (int i = 0; i < m; i++) 
	{
		int j;
        	for (j = index; j < n; j++)
		 {
            		if (frame[i] == pages[j])
			 {
                		if (j > farthest) 
				{
                    			farthest = j;
                    			res = i;
				}
				break;
			}
		}
		if (j == n)
		    return i;
        }
	return (res == -1) ? 0 : res;
}

int findMFU(int pages[], int n, int frame[], int m)
{
	int count[m];
	for (int i = 0; i < m; i++)
        	count[i] = 0;
	for (int i = 0; i < m; i++) 
	{
		for (int j = 0; j < n; j++)
		 {
			if (frame[i] == pages[j])
               		count[i]++;
       		 }
   	 }
	 int min = count[0], res = 0;
	 	for (int i = 1; i < m; i++)
		 {
			if (count[i] < min) 
			{
			    min = count[i];
			    res = i;
			}
		 }
	    return res;
}

int main() 
{
	int n; 
	printf("Enter the number of memory frames: ");
	scanf("%d", &n);

        int referenceString[] = {1,2,3,4,2,1,5,6,2,1,2,3};
        int numReferences = sizeof(referenceString) / sizeof(referenceString[0]);

        int frame[n];
        bool isInFrame[n];

        for (int i = 0; i < n; i++) 
        {
       		 frame[i] = -1;
       		 isInFrame[i] = false;
   	 }

   	int pageFaultsOPT = 0;
    	int pageFaultsMFU = 0;

   	 for (int i = 0; i < numReferences; i++)
    	 {
       		 int page = referenceString[i];

        	 bool pageHit = false;
        	 for (int j = 0; j < n; j++)
        	 {
           		 if (frame[j] == page) 
	     		{
               			 pageHit = true;
                			break;
            		}
        	}

		if (!pageHit) 
		{
			    pageFaultsOPT++;
			    pageFaultsMFU++;

			    int optIndex = findOptimal(referenceString, numReferences, frame, n, i + 1);
			    int mfuIndex = findMFU(referenceString, numReferences, frame, n);

			    frame[optIndex] = page;
			    frame[mfuIndex] = page;
		}
	}

    	printf("Total Page Faults (OPT): %d\n", pageFaultsOPT);
    	printf("Total Page Faults (MFU): %d\n", pageFaultsMFU);

    	return 0;
}
