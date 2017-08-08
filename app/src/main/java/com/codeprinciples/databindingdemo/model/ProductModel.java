package com.codeprinciples.databindingdemo.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.codeprinciples.databindingdemo.BR;
import com.codeprinciples.databindingdemo.util.AppUtils;

/**
 * MIT License
 * <p>
 * Copyright (c) 2017 Oleksiy
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class ProductModel  extends BaseObservable {
    private String name;
    private float price;
    private int quantity;

    public ProductModel(String name, float price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPrice() {
        return AppUtils.moneyFormat(price);
    }

    public void setPrice(String price) {
        this.price = Float.valueOf(price.replace("$",""));
        notifyPropertyChanged(BR.price);
    }

    @Bindable
    public String getQuantity() {
        return String.valueOf(quantity);
    }

    public void setQuantity(String quantity) {
        try {
            this.quantity = Integer.valueOf(quantity);
            notifyPropertyChanged(BR.quantity);
        }catch (NumberFormatException e){
            Log.i("ProductModel", quantity+" is not a valid number");
        }

    }
}
