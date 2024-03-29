package eu.tutorials.moviemagic.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import eu.tutorials.moviemagic.R
import eu.tutorials.moviemagic.databinding.FragmentIntroBinding
import eu.tutorials.moviemagic.ui.MovieViewModel

class IntroFragment : Fragment() {

    private var _binding: FragmentIntroBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_intro, container, false)
        binding.fragment = this
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun buyTickets(ticket: Int) {
        viewModel.setTickets(ticket)
        viewModel.calculateCost()
        findNavController().navigate(R.id.action_introFragment_to_daySelectFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}