/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class AStrArrayTypeProduction extends PTypeProduction
{
    private TStringClass _stringClass_;
    private TLeftBracket _leftBracket_;
    private TRightBracket _rightBracket_;

    public AStrArrayTypeProduction()
    {
        // Constructor
    }

    public AStrArrayTypeProduction(
        @SuppressWarnings("hiding") TStringClass _stringClass_,
        @SuppressWarnings("hiding") TLeftBracket _leftBracket_,
        @SuppressWarnings("hiding") TRightBracket _rightBracket_)
    {
        // Constructor
        setStringClass(_stringClass_);

        setLeftBracket(_leftBracket_);

        setRightBracket(_rightBracket_);

    }

    @Override
    public Object clone()
    {
        return new AStrArrayTypeProduction(
            cloneNode(this._stringClass_),
            cloneNode(this._leftBracket_),
            cloneNode(this._rightBracket_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAStrArrayTypeProduction(this);
    }

    public TStringClass getStringClass()
    {
        return this._stringClass_;
    }

    public void setStringClass(TStringClass node)
    {
        if(this._stringClass_ != null)
        {
            this._stringClass_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._stringClass_ = node;
    }

    public TLeftBracket getLeftBracket()
    {
        return this._leftBracket_;
    }

    public void setLeftBracket(TLeftBracket node)
    {
        if(this._leftBracket_ != null)
        {
            this._leftBracket_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._leftBracket_ = node;
    }

    public TRightBracket getRightBracket()
    {
        return this._rightBracket_;
    }

    public void setRightBracket(TRightBracket node)
    {
        if(this._rightBracket_ != null)
        {
            this._rightBracket_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rightBracket_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._stringClass_)
            + toString(this._leftBracket_)
            + toString(this._rightBracket_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._stringClass_ == child)
        {
            this._stringClass_ = null;
            return;
        }

        if(this._leftBracket_ == child)
        {
            this._leftBracket_ = null;
            return;
        }

        if(this._rightBracket_ == child)
        {
            this._rightBracket_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._stringClass_ == oldChild)
        {
            setStringClass((TStringClass) newChild);
            return;
        }

        if(this._leftBracket_ == oldChild)
        {
            setLeftBracket((TLeftBracket) newChild);
            return;
        }

        if(this._rightBracket_ == oldChild)
        {
            setRightBracket((TRightBracket) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
