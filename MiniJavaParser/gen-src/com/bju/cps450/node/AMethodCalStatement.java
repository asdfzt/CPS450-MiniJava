/* This file was generated by SableCC (http://www.sablecc.org/). */

package com.bju.cps450.node;

import java.util.*;
import com.bju.cps450.analysis.*;

@SuppressWarnings("nls")
public final class AMethodCalStatement extends PStatement
{
    private TIdentifier _identifier_;
    private final LinkedList<PObjectCall> _objectCall_ = new LinkedList<PObjectCall>();
    private TLeftParen _leftParen_;
    private PValuesList _valuesList_;
    private TRightParen _rightParen_;
    private TSemicolon _semicolon_;

    public AMethodCalStatement()
    {
        // Constructor
    }

    public AMethodCalStatement(
        @SuppressWarnings("hiding") TIdentifier _identifier_,
        @SuppressWarnings("hiding") List<?> _objectCall_,
        @SuppressWarnings("hiding") TLeftParen _leftParen_,
        @SuppressWarnings("hiding") PValuesList _valuesList_,
        @SuppressWarnings("hiding") TRightParen _rightParen_,
        @SuppressWarnings("hiding") TSemicolon _semicolon_)
    {
        // Constructor
        setIdentifier(_identifier_);

        setObjectCall(_objectCall_);

        setLeftParen(_leftParen_);

        setValuesList(_valuesList_);

        setRightParen(_rightParen_);

        setSemicolon(_semicolon_);

    }

    @Override
    public Object clone()
    {
        return new AMethodCalStatement(
            cloneNode(this._identifier_),
            cloneList(this._objectCall_),
            cloneNode(this._leftParen_),
            cloneNode(this._valuesList_),
            cloneNode(this._rightParen_),
            cloneNode(this._semicolon_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMethodCalStatement(this);
    }

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
    }

    public LinkedList<PObjectCall> getObjectCall()
    {
        return this._objectCall_;
    }

    public void setObjectCall(List<?> list)
    {
        for(PObjectCall e : this._objectCall_)
        {
            e.parent(null);
        }
        this._objectCall_.clear();

        for(Object obj_e : list)
        {
            PObjectCall e = (PObjectCall) obj_e;
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
            this._objectCall_.add(e);
        }
    }

    public TLeftParen getLeftParen()
    {
        return this._leftParen_;
    }

    public void setLeftParen(TLeftParen node)
    {
        if(this._leftParen_ != null)
        {
            this._leftParen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._leftParen_ = node;
    }

    public PValuesList getValuesList()
    {
        return this._valuesList_;
    }

    public void setValuesList(PValuesList node)
    {
        if(this._valuesList_ != null)
        {
            this._valuesList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._valuesList_ = node;
    }

    public TRightParen getRightParen()
    {
        return this._rightParen_;
    }

    public void setRightParen(TRightParen node)
    {
        if(this._rightParen_ != null)
        {
            this._rightParen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._rightParen_ = node;
    }

    public TSemicolon getSemicolon()
    {
        return this._semicolon_;
    }

    public void setSemicolon(TSemicolon node)
    {
        if(this._semicolon_ != null)
        {
            this._semicolon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semicolon_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._identifier_)
            + toString(this._objectCall_)
            + toString(this._leftParen_)
            + toString(this._valuesList_)
            + toString(this._rightParen_)
            + toString(this._semicolon_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        if(this._objectCall_.remove(child))
        {
            return;
        }

        if(this._leftParen_ == child)
        {
            this._leftParen_ = null;
            return;
        }

        if(this._valuesList_ == child)
        {
            this._valuesList_ = null;
            return;
        }

        if(this._rightParen_ == child)
        {
            this._rightParen_ = null;
            return;
        }

        if(this._semicolon_ == child)
        {
            this._semicolon_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        for(ListIterator<PObjectCall> i = this._objectCall_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PObjectCall) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(this._leftParen_ == oldChild)
        {
            setLeftParen((TLeftParen) newChild);
            return;
        }

        if(this._valuesList_ == oldChild)
        {
            setValuesList((PValuesList) newChild);
            return;
        }

        if(this._rightParen_ == oldChild)
        {
            setRightParen((TRightParen) newChild);
            return;
        }

        if(this._semicolon_ == oldChild)
        {
            setSemicolon((TSemicolon) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}