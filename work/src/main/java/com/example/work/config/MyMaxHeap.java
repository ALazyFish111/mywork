package com.example.work.config;

import com.example.work.entity.mymenu.Dish;

import java.util.Arrays;

public class MyMaxHeap {
    private Dish[] elem;
    private int heapSize = 0;

    public MyMaxHeap() {
        elem = new Dish[16];
    }

    /*
     * 建立大根堆
     * */
    public void buildHeap(Dish[] array){
        for(int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.heapSize++;
        }
        buildMaxHeap(elem,heapSize);
    }

    public void push(Dish value) {
        if (isFull()) {
            //扩容
            this.elem = Arrays.copyOf(this.elem, this.elem.length*2);
        }
        elem[heapSize] = value;
        System.out.println(value.getId());
        heapInsert(heapSize++);
    }

    //已经是大根堆，只需要向上调整
    //如果收了N个数，时间复杂度为logN
    private void heapInsert(int child) {
        int parent = (child-1) / 2;
        while(parent >= 0) {
            if(this.elem[parent].getPrice() < this.elem[child].getPrice()) {
                Dish tmp = this.elem[parent];
                this.elem[parent] = this.elem[child];
                this.elem[child] = tmp;
                child = parent;
                parent = (child-1) / 2;
            } else {
                break;
            }
        }
    }

    // 返回最大值，并在大根堆中把最大值删掉
    // 剩下的数，依然保持大根堆组织
    public Dish pop() {
        if(isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        Dish ans = elem[0];
        swap(elem, 0, --heapSize);
        maxHeapify(elem, 0, heapSize);
        return ans;
    }

    //从最后一个非叶子节点开始，构建大根堆
    private void buildMaxHeap(Dish[] elem, int heapSize){
        int top = (heapSize -2) /2;
        for(int i = top; i>=0; i--){
            maxHeapify(elem,i,heapSize);
        }
    }

    // 堆结构的个关键操作：从某个位置开始往下调整,时间复杂度logN
    public void maxHeapify(Dish[] arr, int parent,int heapSize){
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        int largest = parent;

        if(left < heapSize && arr[left].getPrice() > arr[largest].getPrice()){
            largest = left;
        }

        if(right < heapSize && arr[right].getPrice() > arr[largest].getPrice()){
            largest = right;
        }

        //如果最大值的指针不是父节点，则交换父节点和当前最大值指针指向的子节点。
        if(largest != parent){
            swap(arr,largest,parent);
            //由于交换了父节点和子节点，因此可能对子节点的子树造成影响，所以对子节点的子树进行调整。
            maxHeapify(arr,largest,heapSize);
        }
    }

    private void swap(Dish[] arr, int i, int j) {
        Dish t = arr[i];
        arr[i] =arr[j];
        arr[j] = t;
    }

    public boolean isEmpty() {
        return heapSize==0;
    }

    public boolean isFull() {
        return heapSize==elem.length;
    }


}